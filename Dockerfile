FROM openjdk:17-jdk-slim
VOLUME /app
COPY target/saldo-conta-api.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]