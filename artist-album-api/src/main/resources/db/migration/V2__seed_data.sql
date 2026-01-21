INSERT INTO artist (id, name) VALUES (1, 'Guns N'' Roses');

INSERT INTO album (id, title, release_year) VALUES
(1, 'Use Your Illusion I', 1991),
(2, 'Use Your Illusion II', 1991),
(3, 'Greatest Hits', 2004);

INSERT INTO artist_album (artist_id, album_id) VALUES
(1, 1),
(1, 2),
(1, 3);
