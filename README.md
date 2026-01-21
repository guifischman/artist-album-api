##Artist & Album API — Java Backend##

1. Visão Geral

Este projeto implementa uma API REST em Java para disponibilização e gerenciamento de dados de artistas musicais e seus álbuns, permitindo consultas, cadastros, integrações externas e notificações em tempo real.

O domínio da aplicação é exemplificado com a banda Guns N’ Roses e os álbuns:

Use Your Illusion I (1991)

Use Your Illusion II (1991)

Greatest Hits (2004)

Esses dados são utilizados como carga inicial do banco, versionada via Flyway, garantindo reprodutibilidade e consistência do ambiente.

2. Escopo Funcional

A API oferece as seguintes capacidades:

Cadastro e consulta de artistas (bandas e/ou cantores);

Cadastro e consulta de álbuns musicais;

Relacionamento N:N entre artistas e álbuns;

Consultas parametrizadas para identificar álbuns por tipo de artista;

Paginação e ordenação nas consultas;

Upload de uma ou mais imagens de capa de álbuns;

Armazenamento de imagens em MinIO (API compatível S3);

Geração de links pré-assinados para download das capas;

Notificação em tempo real via WebSocket a cada novo álbum cadastrado.

3. Arquitetura e Tecnologias
Backend

Java 17

Spring Boot

Spring Data JPA

Spring Security + JWT

Persistência

PostgreSQL

Flyway Migrations (criação e carga inicial do banco)

Infraestrutura

Docker

Docker Compose

MinIO (armazenamento de objetos compatível com S3)

Integrações e Qualidade

WebSocket (notificação de novos álbuns)

Rate Limit (10 requisições/minuto por usuário)

Health Check / Liveness / Readiness

OpenAPI / Swagger

As tecnologias foram escolhidas visando padrões de mercado, facilidade de evolução, escalabilidade e manutenibilidade.

4. Versionamento de API

Todos os endpoints são versionados no padrão:

/v1/...


Esse modelo permite evolução futura sem quebra de compatibilidade com consumidores existentes.

5. Como Executar o Projeto
5.1 Execução via Docker (recomendado)

Pré-requisitos:

Docker

Docker Compose

Comando:

docker-compose up --build


Esse comando inicializa:

API Java

Banco de dados PostgreSQL

MinIO

5.2 Execução Local (opcional)

Pré-requisitos:

Java 17+

Maven

Docker (para banco e MinIO)

mvn clean package
docker-compose up

6. Banco de Dados e Carga Inicial

O banco de dados é gerenciado via Flyway.

Na inicialização da aplicação:

As tabelas são criadas automaticamente;

Os dados de exemplo (Guns N’ Roses e seus álbuns) são inseridos;

As migrações são versionadas, garantindo histórico e rastreabilidade.

7. Endpoints Principais (Visão Geral)

Exemplos de endpoints expostos:

GET /v1/artists

GET /v1/artists?name=Guns&sort=asc

GET /v1/albums?page=0&size=10

POST /v1/albums

POST /v1/albums/{id}/covers

GET /v1/albums/{id}/covers (link pré-assinado)

A documentação completa está disponível via Swagger/OpenAPI.

8. Segurança

Autenticação via JWT

Token com expiração de 5 minutos

Endpoint para renovação do token

Rate limit: 10 requisições por minuto por usuário

Restrição de acesso via CORS para domínios autorizados

9. WebSocket

A aplicação disponibiliza um canal WebSocket para notificar clientes sempre que um novo álbum é cadastrado, permitindo integração em tempo real com aplicações frontend.

10. Endpoint de Regionais

A API integra-se ao endpoint externo:

https://integrador-argus-api.geia.vip/v1/regionais


Funcionalidades:

Importação da lista para tabela interna;

Atributo ativo para controle de vigência;

Sincronização com baixa complexidade:

Novo no endpoint → inserir;

Ausente no endpoint → inativar;

Alterado → inativar antigo e criar novo registro.

11. Testes

Testes unitários para camadas de serviço e domínio;

Foco em legibilidade, isolamento e clareza;

Execução via:

mvn test