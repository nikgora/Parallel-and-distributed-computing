FROM openjdk:22
WORKDIR /app
COPY target/java-server-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
