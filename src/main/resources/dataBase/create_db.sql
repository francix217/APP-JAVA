create table USUARIO(
	ID biginit not null AUTO_INCREMENT,
	usuario varchar(80) not null,
	contraseña varchar(80) not null,
	PRIMARY KEY(ID)
);

create table CLIENTE(
	ID biginit not null,
	genero varchar(80) not null,
	ID_ESTADO int not null,
	PRIMARY KEY(ID)
	FOREIGN KEY (ID) REFERENCES LOGIN(ID)
);

alter table CLIENTE add constraint CLI$USU foreign key (ID) references USUARIO(ID);

create table PRODUCTO(
	ID biginit not null AUTO_INCREMENT,
	nombre varchar(80) not null,
	precio int not null,
	PRIMARY KEY(ID)
);

create table PRODUCTO_CLIENTE(
	ID_CLIENTE BIGINT NOT NULL,
	ID_PRODUCTO BIGINT NOT NULL,
	PRIMARY KEY(ID_CLIENTE, ID_PRODUCTO),
);

create table GENERO(
	ID int not null ,
	valor varchar(50) not null,
	PRIMARY KEY(ID)
	FOREIGN KEY (ID) REFERENCES USUARIO(ID)
);

create table LOGIN(
	ID int not null ,
	valor varchar(50) not null,
	PRIMARY KEY(ID)
);
