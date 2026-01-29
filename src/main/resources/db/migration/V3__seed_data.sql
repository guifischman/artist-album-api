-- Inserindo artistas
INSERT INTO artist (name) VALUES
('Guns N’ Roses'),
('Queen'),
('Metallica');

-- Inserindo álbuns
INSERT INTO album (title) VALUES
('Use Your Illusion I'),
('Use Your Illusion II'),
('Greatest Hits'),
('A Night at the Opera'),
('Master of Puppets');

-- Relacionamento artista-álbum
-- Guns N’ Roses
INSERT INTO artist_album (artist_id, album_id) VALUES
((SELECT id FROM artist WHERE name='Guns N’ Roses'), (SELECT id FROM album WHERE title='Use Your Illusion I')),
((SELECT id FROM artist WHERE name='Guns N’ Roses'), (SELECT id FROM album WHERE title='Use Your Illusion II')),
((SELECT id FROM artist WHERE name='Guns N’ Roses'), (SELECT id FROM album WHERE title='Greatest Hits'));
