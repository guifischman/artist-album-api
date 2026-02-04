-- =========================
-- ARTISTS
-- =========================
INSERT INTO artist (id, name, type) VALUES
  (1, 'Serj Tankian', 'SINGER'),
  (2, 'Mike Shinoda', 'SINGER'),
  (3, 'Guns N'' Roses', 'BAND');

-- =========================
-- ALBUMS
-- =========================
INSERT INTO album (id, title, release_year, artist_id) VALUES
  -- Serj Tankian
  (1, 'Harakiri', 2012, 1),
  (2, 'Black Blooms', 2021, 1),
  (3, 'The Rough Dog', 2021, 1),

  -- Mike Shinoda
  (4, 'The Rising Tied', 2005, 2),
  (5, 'Post Traumatic', 2018, 2),
  (6, 'Post Traumatic EP', 2018, 2),
  (7, 'Where''d You Go', 2006, 2),

  -- Guns N' Roses
  (8, 'Use Your Illusion I', 1991, 3),
  (9, 'Use Your Illusion II', 1991, 3),
  (10, 'Appetite for Destruction', 1987, 3);

-- =========================
-- ARTIST <-> ALBUM (N:N)
-- =========================
INSERT INTO artist_album (artist_id, album_id) VALUES
  (1, 1),
  (1, 2),
  (1, 3),

  (2, 4),
  (2, 5),
  (2, 6),
  (2, 7),

  (3, 8),
  (3, 9),
  (3, 10);