FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

# ✅ Add this line to make mvnw executable
RUN chmod +x mvnw

# Now build the project
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Replace this with your actual jar name if needed
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar", "--server.port=8080"]

