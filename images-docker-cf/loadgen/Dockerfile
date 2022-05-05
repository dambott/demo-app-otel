FROM openjdk:11-jre
ARG SERVICE_NAME
RUN echo "service name: $SERVICE_NAME"
COPY ${SERVICE_NAME}.jar /
COPY ${SERVICE_NAME}.properties /otel
ARG TAS_DOMAIN
ENV TAS_DOMAIN=$TAS_DOMAIN
RUN echo "tas domain: $TAS_DOMAIN"
#CMD java -jar /loadgen.jar shopping 50050 50150 2 15 0
CMD java -javaagent:opentelemetry-javaagent.jar -Dotel.javaagent.configuration-file=/otel/loadgen.properties  -jar /loadgen.jar shopping${TAS_DOMAIN} 50050 50150 2 15 0
