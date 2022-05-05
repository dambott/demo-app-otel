FROM openjdk:11-jre
ARG SERVICE_NAME

RUN echo "image name $SERVICE_NAME"
EXPOSE  50051
COPY ${SERVICE_NAME}.jar /
COPY ${SERVICE_NAME}.properties /otel
COPY *.yaml /conf/
CMD java -javaagent:opentelemetry-javaagent.jar -Dotel.javaagent.configuration-file=/otel/styling.properties  -jar /styling.jar server /conf/styling-app.yaml
