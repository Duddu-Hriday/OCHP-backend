# Use official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy all files to the container
COPY . .

# Run Maven wrapper to build the app (skip tests for speed)
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the packaged jar file (replace with your actual jar name)
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
