CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };


CREATE TABLE mykeyspace.perfil (
    id text PRIMARY KEY,
    nome text,
);

CREATE TYPE mykeyspace.perfil (
    nome text
);

CREATE TABLE mykeyspace.usuario (
    id text PRIMARY KEY,
    idade int,
    nome text,
    perfil frozen<perfil>
);
