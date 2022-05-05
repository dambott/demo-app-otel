FROM openjdk:11-jre
ARG SERVICE_NAME

RUN echo "image name $SERVICE_NAME"
COPY ${SERVICE_NAME}.jar /
COPY ${SERVICE_NAME}.properties /otel
COPY *.yaml /conf/
EXPOSE 50056
CMD java -javaagent:opentelemetry-javaagent.jar -Dotel.javaagent.configuration-file=/otel/notification.properties -jar /notification.jar --spring.config.location=/conf/notification-app.yaml
