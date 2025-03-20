create database pruebatecnica;
create table users(
    id              INT                 not null primary key,
    name            varchar(50)         not null,
    password        varchar(255)        not null,
    email           varchar(50)         not null,
);

create table roles(
    id              INT              not null primary key,
    name            varchar(10)         not null,
    constraint pk_role primary key(id)
);

create table users_roles(
    id              int              not null primary key,
    userid          int              not null,
    roleid          int              not null,
    foreign key(userid) references users(id),
    foreign key(roleid) references roles(id)
);



/*************** Insert data ***************/
INSERT INTO roles(id, name) VALUES(1, 'USER');