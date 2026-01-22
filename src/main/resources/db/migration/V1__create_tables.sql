-- Criação da tabela de artistas
CREATE TABLE artist (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Criação da tabela de álbuns
CREATE TABLE album (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

-- Tabela de relacionamento N:N entre artistas e álbuns
CREATE TABLE artist_album (
    artist_id INT NOT NULL,
    album_id INT NOT NULL,
    PRIMARY KEY (artist_id, album_id),
    CONSTRAINT fk_artist FOREIGN KEY (artist_id) REFERENCES artist(id),
    CONSTRAINT fk_album FOREIGN KEY (album_id) REFERENCES album(id)
);