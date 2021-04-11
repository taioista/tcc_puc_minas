# Alpine Linux com OpenJDK 11 JRE
FROM azul/zulu-openjdk-alpine:11

# Copiar pacote .jar e renomear para echo.war
COPY gestao-normas-1.0.0-SNAPSHOT.jar /app.war

# Executar a aplicação
CMD ["/usr/bin/java", "-jar", "/app.war"]