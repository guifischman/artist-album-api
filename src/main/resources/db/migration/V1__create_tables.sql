-- =========================
-- TABELA DE ARTISTAS
-- =========================
CREATE TABLE artist (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL
);

-- =========================
-- TABELA DE ÁLBUNS
-- =========================
CREATE TABLE album (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_year INTEGER NOT NULL,
    artist_id BIGINT NOT NULL,
    CONSTRAINT fk_album_artist
        FOREIGN KEY (artist_id)
        REFERENCES artist(id)
);

-- =========================
-- RELACIONAMENTO N:N
-- ARTISTAS <-> ÁLBUNS
-- =========================
CREATE TABLE artist_album (
    artist_id BIGINT NOT NULL,
    album_id BIGINT NOT NULL,
    PRIMARY KEY (artist_id, album_id),
    CONSTRAINT fk_artist_album_artist
        FOREIGN KEY (artist_id)
        REFERENCES artist(id),
    CONSTRAINT fk_artist_album_album
        FOREIGN KEY (album_id)
        REFERENCES album(id)
);