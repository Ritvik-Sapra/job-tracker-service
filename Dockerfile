# ----- Stage 1: Build -----
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy only pom.xml first (better caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Now copy source code
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests

# ----- Stage 2: Run -----
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy only the built jar from builder stage
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
