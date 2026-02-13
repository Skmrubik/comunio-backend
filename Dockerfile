# Etapa 1: Compilación (Build)
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar el archivo de configuración y descargar dependencias (para aprovechar la caché de Docker)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente y compilar el proyecto saltando los tests
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final (Runtime)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar solo el .jar generado desde la etapa de compilación
# Nota: Ajusta el nombre del .jar si tu proyecto genera uno distinto
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]