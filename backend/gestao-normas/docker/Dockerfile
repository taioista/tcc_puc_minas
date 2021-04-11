# Alpine Linux com OpenJDK 11 JRE
FROM azul/zulu-openjdk-alpine:11

# Copiar pacote .jar e renomear para echo.war
COPY gestao-normas-0.0.1-SNAPSHOT.jar /app.war

# Executar a aplicação
CMD ["/usr/bin/java", "-jar", "/app.war"]