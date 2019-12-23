FROM java:8-jdk-alpine

EXPOSE 9000

ARG JAR_FILE
ADD ${JAR_FILE} /app/lib/app.jar

ARG CONF_FILE
ADD ${CONF_FILE} /app/conf/application.properties

ENTRYPOINT ["java", "-jar", "/app/lib/app.jar"]