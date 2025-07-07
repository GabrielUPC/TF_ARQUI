# Etapa 1: compilar el proyecto y generar el JAR
FROM maven:3.9.6-eclipse-temurin-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: correr la app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/TrabajoArquiweb-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
