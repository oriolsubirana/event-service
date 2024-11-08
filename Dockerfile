# Stage 1: Build the project
FROM gradle:8-jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build

# Stage 2: Run the project
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/app.jar app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080
