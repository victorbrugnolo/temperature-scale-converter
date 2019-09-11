Para executar os testes: 
  Pré requisitos: 
    openjdk 8
    maven
  Executar: 
    mvn tests

Para executar a api:
  Pré requisitos:
    docker compose
  Executar:
    docker-compose build && docker-compose up
  
  Os endpoints ficarão disponíveis para consulta no endereço: http://localhost:8090/swagger-ui.html
