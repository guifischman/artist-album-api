\# Artist Album API



API REST para gerenciamento de artistas e álbuns musicais, desenvolvida em Java com Spring Boot, como solução para desafio técnico.



O projeto foi estruturado visando qualidade de código, clareza arquitetural, facilidade de evolução e aderência aos requisitos propostos no edital.



---



\## Tecnologias Utilizadas



\- Java 17

\- Spring Boot

\- Spring Data JPA

\- Maven

\- Flyway

\- Banco de Dados Relacional (H2/PostgreSQL)

\- OpenAPI / Swagger (em progresso)

\- Docker / Docker Compose (em progresso)



---



\## Modelagem de Domínio



\### Artista

\- Pode representar um \*\*cantor(a)\*\* ou uma \*\*banda\*\*

\- Campos principais:

&nbsp; - `id`

&nbsp; - `name`

&nbsp; - `type` (`SINGER` | `BAND`)



\### Álbum

\- Representa um álbum musical

\- Campos principais:

&nbsp; - `id`

&nbsp; - `title`

&nbsp; - `releaseYear`



\### Relacionamento

\- \*\*Artista ↔ Álbum\*\*: N:N  

&nbsp; Um artista pode ter vários álbuns e um álbum pode estar associado a mais de um artista.



Essa decisão arquitetural foi adotada para garantir escalabilidade e evitar retrabalho em cenários futuros (ex: colaborações).



---



\## Carga Inicial de Dados (Flyway)



O projeto utiliza \*\*Flyway Migrations\*\* para criação e versionamento do schema e carga inicial de dados.



\### Artistas cadastrados



\- Serj Tankian (SINGER)

\- Mike Shinoda (SINGER)

\- Guns N’ Roses (BAND)



\### Álbuns cadastrados



\*\*Serj Tankian\*\*

\- Harakiri (2012)

\- Black Blooms (2021)

\- The Rough Dog (2021)



\*\*Mike Shinoda\*\*

\- The Rising Tied (2005)

\- Post Traumatic (2018)

\- Post Traumatic EP (2018)

\- Where’d You Go (2006)



\*\*Guns N’ Roses\*\*

\- Use Your Illusion I (1991)

\- Use Your Illusion II (1991)

\- Greatest Hits (2004)



A carga inicial permite validação de:

\- Paginação

\- Ordenação

\- Filtros por artista

\- Relacionamento N:N



---



\## Estrutura do Projeto



```text

src/main/java/com/company/artist\_album\_api

├── album

│   ├── controller

│   ├── service

│   ├── repository

│   └── dto

├── artist

│   ├── controller

│   ├── service

│   ├── repository

│   └── dto

└── config



