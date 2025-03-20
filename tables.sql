create database pruebatecnica;
create table users(
    id              INT                 not null  identity primary key,
    name            varchar(50)         not null,
    password        varchar(255)        not null,
    email           varchar(50)         not null,
);

create table roles(
    id              INT              not null identity primary key,
    name            varchar(10)         not null,
    constraint pk_role primary key(id)
);

create table users_roles(
    id              int              not null identity primary key,
    userid          int              not null,
    roleid          int              not null,
    foreign key(userid) references users(id),
    foreign key(roleid) references roles(id)
);


create table tipo_productos(
    id              int             not null identity primary key,
    nombre          varchar(50)     not null,
    usuario_creador  int             not null,
    fecha_creacion   datetime        not null default getdate(),
    usuario_update   int,
    fecha_update     datetime,
    foreign key(usuario_creador) references users(id),
    foreign key(usuario_update) references users(id)
)

create table productos(
    id              int             not null identity primary key,
    nombre          varchar(50)     not null,
    descripcion     varchar(255)    not null,
    precio          decimal(10,2)   not null,
    stock           int             not null,
    tipo_producto    int             not null,
    usuario_creador  int             not null,
    fecha_creacion   datetime        not null default getdate(),
    usuario_update   int,
    fecha_update     datetime,
    foreign key(tipo_producto) references tipo_productos(id),
    foreign key(usuario_creador) references users(id),
    foreign key(usuario_update) references users(id)
)




/*************** Insert data ***************/
INSERT INTO roles(id, name) VALUES(1, 'USER');
INSERT INTO tipo_productos(nombre, usuario_creador) VALUES('Laptop',1);
INSERT INTO tipo_productos(nombre, usuario_creador) VALUES('Desktop',1);
INSERT INTO tipo_productos(nombre, usuario_creador) VALUES('Tablet',1);
INSERT INTO tipo_productos(nombre, usuario_creador) VALUES('Smartphone',1);