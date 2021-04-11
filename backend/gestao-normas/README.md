# TCC PUC Minas  

Para construir a imagem do container da aplicação é necessário utilizar os comandos abaixo:  
 ./mvnw clean install  
 docker build -t normas-api .  
 docker tag normas-api sigo/normas-api  
  
Para rodar a aplicação fora do docker é necessário rodar o comando:  
 ./mvnw spring-boot:run  
  
E criar as seguintes variáveis de ambiente:  
 NORMA_API_DB_HOST=jdbc:postgresql://localhost  
 NORMA_API_DB_PORT=5432  
 NORMA_API_DB_USERNAME=admin  
 NORMA_API_DB_PASSWORD=admin  
 NORMA_API_PORT=8080  
 NORMA_API_EXTERNA=<http://localhost:3000/normas>
