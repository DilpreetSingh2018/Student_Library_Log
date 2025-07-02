## Use OpenJDK base image
#FROM openjdk:17-jdk-slim
#
## Set working directory inside container
#WORKDIR /app
#
## Copy jar file to container
#COPY target/StudentLib-0.0.1-SNAPSHOT.jar app.jar
#
#
#EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]
## Start the application
##ENTRYPOINT ["java", "-jar", "app.jar"]
