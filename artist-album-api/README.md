# Artist & Album API

## Objetivo
API REST para disponibilizar dados sobre artistas e seus álbuns.

## Exemplo base (tema do projeto)
A aplicação inicia com os seguintes dados cadastrados:

Artista:
- Guns N' Roses

Álbuns:
- Use Your Illusion I (1991)
- Use Your Illusion II (1991)
- Greatest Hits (2004)

Esses dados são inseridos automaticamente via Flyway na inicialização do banco.

## Como executar

```bash
mvn clean package
docker-compose up --build -d