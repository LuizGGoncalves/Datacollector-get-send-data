FROM openjdk
WORKDIR /app

COPY target/api-load-data-0.0.1-SNAPSHOT.jar /app/spring-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-app.jar"]