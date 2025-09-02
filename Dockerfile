# Stage 1: Build the WAR file
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src
	
# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Deploy the WAR file
FROM tomcat:10.1-jdk17-temurin

EXPOSE 8080

# Copy the WAR file from the build stage to Tomcat's webapps folder
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/
