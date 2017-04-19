CREATE TABLE customer (id varchar PRIMARY KEY, firstname text, lastname text);

CREATE TABLE perfil (id varchar PRIMARY KEY, nome text);
CREATE TYPE IF NOT EXISTS perfil (nome text);

CREATE TABLE usuario (id varchar PRIMARY KEY, nome text, idade int, perfil frozen<perfil>);




CREATE TYPE IF NOT EXISTS usuario (id varchar PRIMARY KEY, nome text, idade int, perfil frozen<perfil>);