BEGIN TRANSACTION;

DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE roles(
    id serial not null,
    nombre varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS usuarios CASCADE;
CREATE TABLE usuarios(
    id serial not null,
    rut int not null,
    nombre varchar(255) not null,
    password varchar(255) not null,
    rol_id int NOT NULL REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE,
    primary key(id)
);

DROP TABLE IF EXISTS formas_pagos CASCADE;
CREATE TABLE formas_pagos(
    id serial not null,
    nombre varchar(255) not null,
    primary key(id)
);


DROP TABLE IF EXISTS tipos_productos cascade;
create table tipos_productos(
    id serial not null,
    nombre varchar(255) not null,
    primary key(id)
);


DROP TABLE IF EXISTS productos cascade;
create table productos(
    id serial not null,
    nombre varchar(255) not null,
    stock boolean  DEFAULT '1' not null,
    tipo_producto_id int NOT NULL REFERENCES tipos_productos(id) ON UPDATE CASCADE ON DELETE CASCADE,
    valor int not null,
    primary key(id)

);


DROP TABLE IF EXISTS mesas CASCADE;
create table mesas(
    id serial not null,
    numero int not null,
    estado varchar(255) not null,
    capacidad int not null,
    primary key(id)
);

DROP TABLE IF EXISTS pedidos cascade;
CREATE TABLE pedidos(
    id serial not null,
    mesa_id int NOT NULL REFERENCES mesas(id) ON UPDATE CASCADE ON DELETE CASCADE,
    usuario_id int NOT NULL REFERENCES usuarios(id) ON UPDATE CASCADE ON DELETE CASCADE,
    primary key(id)
);

DROP TABLE IF EXISTS pedidos_productos CASCADE;
create table pedidos_productos(
    id serial not null,
    pedido_id int NOT NULL REFERENCES pedidos(id) ON UPDATE CASCADE ON DELETE CASCADE,
    producto_id int NOT NULL REFERENCES productos(id) ON UPDATE CASCADE ON DELETE CASCADE,
    monto int default 0 not null,
    fecha timestamp NOT NULL DEFAULT NOW(),
    primary key(id)
);


DROP TABLE IF EXISTS boletas CASCADE;
create table boletas(
    id serial not null,
    monto int not null,
    propina int not null,
    fecha timestamp NOT NULL DEFAULT NOW(),
    forma_pago_id int NOT NULL REFERENCES formas_pagos(id) ON UPDATE CASCADE ON DELETE CASCADE,
    pedido_producto_id int NOT NULL REFERENCES pedidos_productos(id) ON UPDATE CASCADE ON DELETE CASCADE,
    primary key(id)
);

DROP TABLE IF EXISTS turnos CASCADE;
create table turnos(
    id serial not null,
    usuario_id int NOT NULL REFERENCES usuarios(id) ON UPDATE CASCADE ON DELETE CASCADE,
    ingreso timestamp NOT NULL DEFAULT NOW(),
    salida timestamp NOT NULL DEFAULT NOW(),
    fecha timestamp NOT NULL DEFAULT NOW(),
    primary key(id)
);


COMMIT;

