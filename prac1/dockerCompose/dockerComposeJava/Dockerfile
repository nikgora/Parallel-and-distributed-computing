# Use an official Maven image to build the project
FROM maven:3.9.9-eclipse-temurin-22 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and project source code to the container
COPY pom.xml .
COPY src ./src

# Build the project (compile and package)
RUN mvn clean package


# Use an official OpenJDK image to run the application
FROM eclipse-temurin:22-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the build image
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (optional)
EXPOSE 9090

# Run the jar file
CMD ["java", "-jar", "app.jar"]
