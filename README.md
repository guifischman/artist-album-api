Artist Album API

API REST desenvolvida em Spring Boot para gerenciamento de artistas, álbuns e seus relacionamentos, com documentação via Swagger/OpenAPI, paginação, filtros e segurança baseada em JWT.

 Tecnologias utilizadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Spring Security (JWT)

Spring Actuator

Springdoc OpenAPI (Swagger)

Maven

Banco de dados relacional (configurável por profile)

 Como executar o projeto
Pré-requisitos

Java JDK 17 ou superior

Maven 3.9+

Passos
# ativar profile de desenvolvimento
$env:SPRING_PROFILES_ACTIVE="dev"


# executar aplicação
mvn spring-boot:run

A aplicação será iniciada em:

http://localhost:8080

 Documentação da API (Swagger)

Swagger UI:

http://localhost:8080/swagger-ui.html

OpenAPI JSON:

http://localhost:8080/v3/api-docs

A documentação é gerada automaticamente a partir dos controllers e DTOs.

 Segurança e Autenticação

A API utiliza JWT (Bearer Token) como mecanismo de autenticação.

Header esperado:

Authorization: Bearer <token>

Os endpoints públicos e protegidos são definidos via configuração de segurança.

O Swagger já está configurado para aceitar autenticação via Bearer Token.

Observação: a implementação de segurança segue os critérios do desafio e pode ser estendida para controle de roles e permissões.

 Health Checks

Foram implementados endpoints de saúde para monitoramento da aplicação:

Liveness:

GET /health/liveness

Readiness:

GET /health/readiness

Esses endpoints permitem verificar se a aplicação está ativa e pronta para receber requisições.

 Principais Endpoints
Artists

GET /api/v1/artists

POST /api/v1/artists

PUT /api/v1/artists/{id}

Albums

GET /albums

GET /albums/{id}

POST /albums

PUT /albums/{id}

DELETE /albums/{id}

Todos os endpoints aceitam e retornam JSON.


 Observações finais

A API foi estruturada seguindo boas práticas de separação de responsabilidades (Controller, Service, DTO).

O projeto está preparado para evolução futura (ex: novos relacionamentos, roles de segurança, versionamento de API).

Swagger e Health checks fazem parte dos critérios de avaliação técnica do projeto.