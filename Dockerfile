# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy jar file to container
COPY target/*.jar app.jar

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
