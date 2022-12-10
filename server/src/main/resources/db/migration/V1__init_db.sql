CREATE TABLE Playlist (
    id SERIAL NOT NULL,
    name int4 NOT NULL,
    song_count int4 NOT NULL,
    Userid int4 NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Role (
    id SERIAL NOT NULL,
    name int4 NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Song (
    id SERIAL NOT NULL,
    name int4 NOT NULL,
    length int4 NOT NULL,
    author_name varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE SongInPlaylist (
    Songid int4 NOT NULL,
    Playlistid int4 NOT NULL,
    PRIMARY KEY (Songid, Playlistid)
);

CREATE TABLE "User" (
    id SERIAL NOT NULL,
    login varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    Roleid int4 NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE SongInPlaylist
ADD CONSTRAINT FKSongInPlay675062 FOREIGN KEY (Playlistid) REFERENCES Playlist (id);

ALTER TABLE SongInPlaylist
ADD CONSTRAINT FKSongInPlay881829 FOREIGN KEY (Songid) REFERENCES Song (id);

ALTER TABLE Playlist
ADD CONSTRAINT FKPlaylist605568 FOREIGN KEY (Userid) REFERENCES "User" (id);

ALTER TABLE "User"
ADD CONSTRAINT FKUser347743 FOREIGN KEY (Roleid) REFERENCES Role (id);