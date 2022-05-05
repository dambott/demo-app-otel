FROM openjdk:11-jre
ARG SERVICE_NAME

RUN echo "image name $SERVICE_NAME"
COPY ${SERVICE_NAME}.jar /
COPY *.yaml /conf/
COPY *.properties /otel/
EXPOSE 50054
CMD  java -javaagent:opentelemetry-javaagent.jar -Dotel.javaagent.configuration-file=/otel/shopping.properties -jar /delivery.jar  --spring.config.location=/conf/delivery-app.yaml
