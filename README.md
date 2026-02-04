# Artist Album API

Projeto de **Back End (API REST)** desenvolvido em **Spring Boot**, responsável pelo gerenciamento de artistas, álbuns e seus relacionamentos, conforme escopo definido em edital.  
O projeto contempla exclusivamente a camada de servidor, não incluindo front-end.

Tecnologias principais:
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- Flyway
- SpringDoc OpenAPI (Swagger)
- Maven

A arquitetura é baseada em **camadas bem definidas**, com separação clara de responsabilidades, preparada para manutenção, testes e evolução.

---

## Arquitetura e Estrutura

Estrutura base do projeto:

src/main/java/com/company/artist_album_api  
- controller: camada de exposição da API (endpoints REST versionados)  
- service: camada de regras de negócio  
- repository: camada de persistência (JPA)  
- model: entidades do domínio  
- auth: autenticação e controle de acesso  
- security: configuração de segurança, filtros e JWT  
- config: configurações globais da aplicação  
- ArtistAlbumApiApplication.java: classe principal da aplicação  

A organização segue o padrão **Controller → Service → Repository**, garantindo desacoplamento e legibilidade do código.

---

## Versionamento da API

A API é versionada via URL utilizando o prefixo `/api/v1`, permitindo evolução futura sem quebra de contrato.

Exemplos:
- `/api/v1/artists`
- `/api/v1/albums`

---

## Documentação da API (Swagger)

A documentação da API é gerada automaticamente via **OpenAPI/Swagger** utilizando SpringDoc.

Após subir a aplicação, a documentação pode ser acessada em:

http://localhost:8080/swagger-ui.html  
ou  
http://localhost:8080/swagger-ui/index.html

Todos os endpoints REST disponíveis estão descritos com seus métodos, parâmetros e respostas.

---

## Banco de Dados e Migrations

O versionamento e controle do banco de dados é realizado com **Flyway**, garantindo histórico e rastreabilidade das alterações de schema.

As migrations estão localizadas em:

src/main/resources/db/migration

As migrations são executadas automaticamente durante a inicialização da aplicação.

---

## Segurança e Autenticação (JWT)

O projeto implementa **autenticação baseada em JWT (JSON Web Token)** utilizando **Spring Security**, operando de forma stateless.

Componentes principais:
- JwtService: geração, validação e extração de informações do token
- JwtAuthenticationFilter: interceptação das requisições e autenticação do usuário
- SecurityConfig: configuração de segurança, filtros e políticas de acesso

Fluxo resumido:
1. O usuário realiza login com credenciais válidas
2. A API retorna um token JWT
3. O token deve ser enviado no header `Authorization` nas requisições protegidas

Formato:
Authorization: Bearer <token>

Os endpoints públicos e protegidos são definidos explicitamente na configuração de segurança.

---

## Configurações da Aplicação

As configurações principais da aplicação estão centralizadas em:

src/main/resources/application.yml

Perfis específicos (como `test`) são utilizados para execução de testes, permitindo:
- Desativação de integrações externas
- Ajustes de JPA e Flyway
- Isolamento do ambiente de testes

---

## Execução do Projeto

Pré-requisitos:
- Java 17 ou superior
- Maven 3.8 ou superior

Clone do repositório:
git clone https://github.com/guifischman/guilhermefischman373886

Acesso ao diretório:
cd artist-album-api

Execução da aplicação:
mvn spring-boot:run

Execução dos testes:
mvn test

---

## Testes

Os testes utilizam **JUnit 5** e **Spring Boot Test**, garantindo:
- Carregamento correto do contexto da aplicação
- Validação da configuração de segurança em ambiente de teste
- Base para expansão de testes unitários e de integração

---

## Considerações Técnicas

O projeto foi estruturado visando:
- Clareza arquitetural
- Manutenibilidade
- Evolução futura
- Aderência às boas práticas de desenvolvimento Back End
- Atendimento direto aos critérios do edital

---

## Próximas Evoluções Previstas

- Paginação e filtros avançados
- Upload de arquivos e integração com MinIO
- Health checks e liveness probes
- Rate limiting e políticas de CORS
- WebSocket para notificações em tempo real