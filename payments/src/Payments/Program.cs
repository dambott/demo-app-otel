

using System.IO;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Configuration;
using OpenTelemetry;
using OpenTelemetry.Resources;
using OpenTelemetry.Trace;
using Microsoft.Extensions.Configuration.Json;
using Microsoft.Extensions.Logging.Console;
using Microsoft.Extensions.Logging.Debug;
using YamlDotNet.Serialization;
using YamlDotNet.Serialization.NamingConventions;

namespace Payments
{
    public class Program
    {
        public static void Main(string[] args)
        {
            CreateWebHostBuilder(args);
        }

           class appConfiguration
            {
            public string application { get; set; } = default!;
            public string cluster { get; set; } = default!;
            public string service { get; set; } = default!;
            public string shard { get; set; } = default!;
           // public List<string> customTags { get; set; } = default!;
            };

           class wfConfiguration
            {
            public string reportingMechanism { get; set; } = default!;
            public string proxyHost { get; set; } = default!;
            public int proxyMetricsPort { get; set; } = default!;
            public int proxyDistributionsPort { get; set; } = default!;
            public int proxyTracingPort { get; set; } = default!;
            public bool reportTraces { get; set; } = default!;
            };
        public static WebApplicationBuilder CreateWebHostBuilder(string[] args)
        {

var builder = WebApplication.CreateBuilder( args);

            builder.Logging.AddFilter("System", LogLevel.Trace);
            builder.Logging.AddFilter<DebugLoggerProvider>("Microsoft", LogLevel.Trace);
            builder.Logging.AddFilter<ConsoleLoggerProvider>("Microsoft", LogLevel.Trace);
            builder.Logging.SetMinimumLevel(LogLevel.Trace);
  
            builder.Services.AddControllers();

            // Read tag information from file
            var deserializer = new YamlDotNet.Serialization.DeserializerBuilder()
                .WithNamingConvention(LowerCaseNamingConvention.Instance)
                .Build();
            var appConfig = deserializer.Deserialize<appConfiguration>(File.ReadAllText("/conf/payments-app-tags.yaml"));

            var resourceList = new List<KeyValuePair<string, object>>();
            resourceList.Add(new KeyValuePair<string, object>
                            ("application", appConfig.application));
            resourceList.Add(new KeyValuePair<string, object>
                            ("cluster", appConfig.cluster));
            resourceList.Add(new KeyValuePair<string, object>
                             ("shard", appConfig.shard));

         // Read wf config information from file
            var deserializer2 = new YamlDotNet.Serialization.DeserializerBuilder()
                .WithNamingConvention(CamelCaseNamingConvention.Instance)
                .Build();
            var wfconfig = deserializer2.Deserialize<wfConfiguration>(File.ReadAllText("/conf/wf-config.yaml"));

            builder.Configuration.AddJsonFile("appsettings.json");
            builder.WebHost.UseUrls("http://*:50063");
  //          builder.WebHost.UseUrls($"http://*:{appConfig["port"]}");
            builder.Services.AddOpenTelemetryTracing(tracerProviderBuilder =>
            {  // Could make this optional with reportTraces value from wfConfig
                tracerProviderBuilder.AddAspNetCoreInstrumentation();
                tracerProviderBuilder.AddHttpClientInstrumentation();
                tracerProviderBuilder.SetResourceBuilder(ResourceBuilder.CreateDefault()
                    .AddService(appConfig.service).AddAttributes(resourceList));
  //                  .AddService("payments").AddAttributes(resourceList));
                tracerProviderBuilder.AddSource("BackEnd");
                tracerProviderBuilder.AddOtlpExporter(options =>
                {
     //               options.Endpoint = new Uri("http://tacocat-wavefront-proxy:4317");
                    options.Endpoint = new Uri($"http://{wfconfig.proxyHost}:{wfconfig.proxyTracingPort}");
                    options.ExportProcessorType = ExportProcessorType.Simple;
                });
            });
            using var app = builder.Build();
     //        app.UseStaticFiles();
     //        app.UseRouting();
     //         app.AddYamlFile("payments-app.yml");
               app.MapControllers();

            app.Run("http://*:50063");
            return (builder);
        }
    }
 }