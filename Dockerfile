# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host machine to the container
COPY target/EMS_MAIN-0.0.1-SNAPSHOT.jar app.jar

# Make port 3002 available to the world outside this container
EXPOSE 3002

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]