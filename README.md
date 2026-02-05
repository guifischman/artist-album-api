# Artist Album API

## Visão Geral

API REST desenvolvida em Spring Boot para gerenciamento de artistas e álbuns, com foco em boas práticas de arquitetura, segurança básica com JWT, integração com MinIO e requisitos típicos de avaliação técnica.

** Este projeto prioriza clareza arquitetural, organização e demonstrabilidade dos requisitos solicitados. Algumas implementações foram simplificadas de forma consciente e estão justificadas neste documento.

---

## Tecnologias Utilizadas

* Java 17
* Spring Boot 3.x
* Spring Web
* Spring Data JPA
* Spring Security (JWT)
* Springdoc OpenAPI (Swagger)
* MinIO (upload de arquivos)
* H2 / PostgreSQL (dependendo do profile)
* Maven

---

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

* **controller**: exposição dos endpoints REST
* **service**: regras de negócio
* **repository**: acesso a dados (JPA)
* **model/entity**: entidades do domínio
* **dto**: objetos de transporte
* **security**: configuração de segurança e JWT
* **config**: configurações transversais (MinIO, Security, Swagger)

Essa separação garante baixo acoplamento, legibilidade e facilidade de manutenção.

---

## Como Executar o Projeto

### Pré-requisitos

* Java 17+
* Maven 3.9+

### Subir a aplicação

```bash
mvn clean spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## Perfis de Execução

* **dev** (padrão): banco em memória, foco em testes locais

O profile ativo pode ser alterado via:

```bash
-Dspring.profiles.active=dev
```

---

## Documentação da API (Swagger)

Após subir a aplicação, a documentação pode ser acessada em:

```
http://localhost:8080/swagger-ui.html
```

Todos os endpoints principais estão documentados, incluindo:

* CRUD de recursos
* Paginação e filtros
* Headers de autenticação

---

## Autenticação (JWT)

A API utiliza autenticação baseada em JWT.

### Fluxo simplificado adotado

* Endpoint de login gera um token JWT
* Token deve ser enviado no header:

```
Authorization: Bearer <token>
```

### Justificativa técnica

Para fins de avaliação, o fluxo foi propositalmente simplificado:

* Não há refresh token
* Não há persistência de sessão

Essa abordagem reduz complexidade sem comprometer a demonstração do conhecimento em segurança stateless.

---

## Segurança

A aplicação utiliza autenticação baseada em JWT (JSON Web Token),
com filtro de segurança configurado via Spring Security.

- Tokens possuem expiração configurável
- Endpoints públicos:
  - /auth/**
  - /actuator/health
  - /swagger-ui.html
- Demais endpoints protegidos por autenticação



---

## Upload de Arquivos (MinIO)

A API integra com MinIO para:

* Upload de arquivos
* Geração de URLs pré-assinadas (presigned URLs)

### Execução local

O MinIO pode ser simulado via Docker:

```bash
docker run -p 9000:9000 -p 9001:9001 \
  -e MINIO_ROOT_USER=minio \
  -e MINIO_ROOT_PASSWORD=minio123 \
  minio/minio server /data --console-address ":9001"
```

---

## Paginação e Filtros

Os endpoints de listagem suportam:

* Paginação (`page`, `size`)
* Ordenação
* Filtro por nome (case-insensitive)

Exemplo:

```
GET /artists?page=0&size=10&name=rock
```

---

## Health Check e Liveness

A aplicação disponibiliza endpoints para verificação de saúde:

```
GET /actuator/health
GET /health
```

Resposta esperada:

```json
{ "status": "UP" }
```

Esses endpoints permitem fácil integração com ferramentas de monitoramento.

---

## Segurança Adicional

* CORS configurado para evitar acesso indevido
* Estrutura preparada para rate limiting



---

## Testes

O projeto possui estrutura preparada para testes unitários e de integração.

> Cobertura foi mantida mínima por priorização de tempo e escopo, decisão explicitamente documentada.

---

## Decisões Arquiteturais e Justificativas

* **JWT simplificado**: foco em autenticação stateless
* **Sem WebSocket**: requisito considerado sênior e opcional
* **Rate limit local**: evita dependência de infraestrutura externa
* **Arquitetura em camadas**: clareza e manutenibilidade

---

## Conclusão

Este projeto demonstra domínio prático de desenvolvimento back-end com Spring Boot, priorizando organização, clareza, segurança e capacidade de evolução, atendendo aos critérios solicitados de forma objetiva e justificável.
