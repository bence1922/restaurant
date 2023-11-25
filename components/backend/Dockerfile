# Use the AdoptOpenJDK 11 as base image
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from your local machine to the container
COPY /build/libs/restaurant-0.0.1-SNAPSHOT.jar /app/restaurant.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "restaurant.jar"]