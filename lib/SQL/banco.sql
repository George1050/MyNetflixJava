create table filme (
cod_filme serial not null primary key,
nome varchar(200),
genero int,
duracao varchar(10),
sinopse varchar(255)
);


create table serie (
cod_serie serial not null primary key,
nome varchar(200),
genero int,
num_epi int,
sinopse varchar(255)
);


create table genero (
id_genero serial not null primary key,
nome varchar(200)
);


create table usuario(
id_usuario serial not null primary key,
login varchar(255),
prioridade int,
senha varchar(12)
);

insert into genero (nome) values ('Drama'); 
insert into genero (nome) values ('Terror');
insert into genero (nome) values ('Romance');
insert into genero (nome) values ('Musicais');
insert into genero (nome) values ('Fic��o');
insert into genero (nome) values ('Fantasia');
insert into genero (nome) values ('Com�dia');
insert into genero (nome) values ('Document�rio');
insert into genero (nome) values ('Aventura');
insert into genero (nome) values ('Anima��o');
insert into genero (nome) values ('A��o');
insert into genero (nome) values ('Suspense');
insert into genero (nome) values ('Er�tico');
insert into genero (nome) values ('Guerra');

      