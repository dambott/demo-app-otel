FROM openjdk:11-jre
ARG SERVICE_NAME

RUN echo "image name $SERVICE_NAME"
COPY ${SERVICE_NAME}.jar /
COPY ${SERVICE_NAME}.properties /otel
COPY *.yaml /conf/
EXPOSE 50052
CMD java -javaagent:opentelemetry-javaagent.jar -Dotel.javaagent.configuration-file=/otel/printing.properties  -jar /printing.jar /conf/printing-app.yaml
