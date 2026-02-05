Artist Album API

API REST desenvolvida em Spring Boot para gerenciamento de artistas, álbuns e arquivos associados, com foco em boas práticas de arquitetura, segurança, escalabilidade e documentação.

Este projeto foi estruturado visando critérios técnicos de avaliação backend sênior, incluindo autenticação JWT, documentação OpenAPI, health checks e organização em camadas.

🛠️ Stack Tecnológica

Java 17

Spring Boot 3

Spring Web

Spring Data JPA

Spring Security (JWT)

Flyway (migrations)

H2 Database (ambiente dev)

MinIO (upload de arquivos)

Springdoc OpenAPI (Swagger)

Maven

📁 Arquitetura do Projeto

Estrutura organizada em camadas bem definidas:

controller  → exposição REST
service     → regras de negócio
repository  → acesso a dados
model       → entidades JPA
dto         → contratos de entrada e saída
security    → autenticação e autorização
config      → configurações globais


Essa separação garante:

Baixo acoplamento

Alta legibilidade

Facilidade de manutenção e evolução

▶️ Como Executar o Projeto
Pré-requisitos

Java 17+

Maven 3.9+

(Opcional) Docker para MinIO

Executando localmente
mvn spring-boot:run


O perfil dev é carregado automaticamente.

🔐 Autenticação JWT

A API utiliza JWT stateless para autenticação.

Fluxo:

Usuário autentica via endpoint de login

Recebe um Access Token JWT

O token deve ser enviado no header:

Authorization: Bearer <token>


Filtros validam o token a cada requisição protegida

Características:

Tokens com expiração configurável

Validação de assinatura (HS256)

Renovação suportada

Endpoints públicos liberados explicitamente

📄 Documentação — Swagger / OpenAPI

A API é totalmente documentada via Swagger.

Acesso:
http://localhost:8080/swagger-ui.html


Ou:

http://localhost:8080/swagger-ui/index.html


A definição OpenAPI está disponível em:

/v3/api-docs

❤️ Health Checks (Liveness & Readiness)

Endpoints de verificação de saúde do serviço:

Liveness

GET /health/liveness


Readiness

GET /health/readiness


Esses endpoints são públicos e compatíveis com ambientes containerizados e orquestração (Kubernetes).

📦 Funcionalidades Implementadas

CRUD completo de artistas

CRUD completo de álbuns

Paginação e filtros

Upload de arquivos com MinIO

Geração de URLs assinadas (presigned URLs)

Autenticação JWT

Segurança com filtros e CORS

Health checks

Documentação OpenAPI

🔒 Segurança

Spring Security com configuração explícita

Filtro JWT customizado

Exclusão de Swagger, Actuator e endpoints públicos do filtro

Arquitetura preparada para rate limiting e RBAC

🧪 Qualidade e Boas Práticas

Código limpo e legível

Responsabilidades bem definidas

Versionamento incremental

Estrutura preparada para crescimento

Decisões técnicas documentadas

🚀 Evoluções Futuras

Persistência em banco relacional (PostgreSQL)

Cache com Redis

Rate limit por IP

Observabilidade (Micrometer + Prometheus)

Integração com mensageria (Kafka/RabbitMQ)

👨‍💻 Autor

Projeto desenvolvido como avaliação técnica backend, com foco em qualidade de código, arquitetura e maturidade profissional.

🏁 Status

✔ API estável
✔ Swagger funcional
✔ Segurança validada
✔ Health checks operacionais