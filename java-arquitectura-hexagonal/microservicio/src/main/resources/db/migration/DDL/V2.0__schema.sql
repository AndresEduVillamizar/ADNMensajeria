create table envio (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 premium bit not null,
 primary key (id)
);