# Artist Album API

Projeto de **Back End (API REST)** desenvolvido em **Spring Boot**, responsável pelo gerenciamento de artistas, álbuns e seus relacionamentos, conforme escopo definido em edital.  
O projeto contempla exclusivamente a camada de servidor, não incluindo front-end.

Tecnologias principais:
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Flyway
- SpringDoc OpenAPI (Swagger)
- Maven

Arquitetura baseada em **camadas bem definidas**, com separação clara de responsabilidades, preparada para manutenção, testes e evolução.

Estrutura do projeto:

src/main/java/com/company/artist_album_api  
- controller: camada de exposição da API (endpoints REST versionados)  
- service: camada de regras de negócio  
- repository: camada de persistência (JPA)  
- model: entidades do domínio  
- ArtistAlbumApiApplication.java: classe principal da aplicação

A API é versionada via URL utilizando o prefixo `/api/v1`, permitindo evolução futura sem quebra de contrato.

Exemplo:
- `/api/v1/artists`
- `/api/v1/albums`

A documentação da API é gerada automaticamente via **OpenAPI/Swagger**.  
Após subir a aplicação, a documentação pode ser acessada em:

http://localhost:8080/swagger-ui.html  
ou  
http://localhost:8080/swagger-ui/index.html

O versionamento e controle do banco de dados é realizado com **Flyway**, garantindo histórico e rastreabilidade das alterações de schema.  
As migrations estão localizadas em:

src/main/resources/db/migration

As configurações da aplicação estão centralizadas no arquivo:

src/main/resources/application.yml

Perfis específicos (como `test`) são utilizados para execução de testes, permitindo desabilitar integrações externas e ajustes de JPA quando necessário.

Execução do projeto:

Pré-requisitos:
- Java 17 ou superior
- Maven 3.8 ou superior

Comandos:

Clone do repositório:
git clone <https://github.com/guifischman/guilhermefischman373886>

Acesso ao diretório:
cd artist-album-api

Execução da aplicação:
mvn spring-boot:run

Execução dos testes:
mvn test

Os testes utilizam **JUnit 5** e **Spring Boot Test**, garantindo o carregamento correto do contexto da aplicação e fornecendo base para expansão de testes unitários e de integração.

O projeto foi estruturado visando:
- Clareza arquitetural
- Manutenibilidade
- Evolução futura
- Aderência às boas práticas de desenvolvimento Back End

Evoluções previstas incluem autenticação JWT, upload de arquivos, WebSocket, health checks, rate limiting e observabilidade.