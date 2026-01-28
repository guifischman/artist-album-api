-- =========================
-- ARTISTS
-- =========================
INSERT INTO artist (id, name, type) VALUES
  (1, 'Serj Tankian', 'SINGER'),
  (2, 'Mike Shinoda', 'SINGER'),
  (3, 'Guns N’ Roses', 'BAND');

-- =========================
-- ALBUMS
-- =========================
INSERT INTO album (id, title, release_year) VALUES
  -- Serj Tankian
  (1, 'Harakiri', 2012),
  (2, 'Black Blooms', 2021),
  (3, 'The Rough Dog', 2021),

  -- Mike Shinoda
  (4, 'The Rising Tied', 2005),
  (5, 'Post Traumatic', 2018),
  (6, 'Post Traumatic EP', 2018),
  (7, 'Where’d You Go', 2006),

  -- Guns N’ Roses
  (8, 'Use Your Illusion I', 1991),
  (9, 'Use Your Illusion II', 1991),
  (10, 'Greatest Hits', 2004);

-- =========================
-- ARTIST_ALBUM (N:N)
-- =========================
INSERT INTO artist_album (artist_id, album_id) VALUES
  -- Serj Tankian
  (1, 1),
  (1, 2),
  (1, 3),

  -- Mike Shinoda
  (2, 4),
  (2, 5),
  (2, 6),
  (2, 7),

  -- Guns N’ Roses
  (3, 8),
  (3, 9),
  (3, 10);