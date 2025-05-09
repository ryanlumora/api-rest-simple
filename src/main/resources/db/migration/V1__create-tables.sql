create table veiculos (
    id bigint not null auto_increment,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    ano varchar(100) not null,
    primary key (id)
);

create table mecanicos (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    experiencia varchar(100),
    primary key (id)
);

create table consertos (
    id bigint not null auto_increment,
    entrada varchar(100) not null,
    saida varchar(100) not null,
    id_mecanico bigint not null,
    id_veiculo bigint not null,
    primary key (id),
    foreign key (id_mecanico) references mecanicos(id),
    foreign key (id_veiculo) references veiculos(id)
);
