# Integração com API externa de normas

Neste módulo é utilizada uma biblioteca (JSON-Server) para servir de mock do repositório externo de normas.
Essa biblioteca gera uma API Rest a partir do arquivo db.json que contém os dados mock que serão retornados para o módulo do SIGO quando for solicitado.

# Utilização
Utilizar os passos abaixo para levantar o serviço:

1- npm install  
2- json-server --watch db.json
