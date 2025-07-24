FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/portfolio-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9999

CMD [ "java", "-jar", "app.jar" ]

