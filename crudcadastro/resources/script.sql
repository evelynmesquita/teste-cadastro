create database registro;

create table clientes (
    codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14),
    idade INT
);