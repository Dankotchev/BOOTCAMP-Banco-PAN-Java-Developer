DROP DATABASE IF EXISTS dio_companhia;
CREATE DATABASE IF NOT EXISTS dio_companhia;

USE dio_companhia;

CREATE TABLE IF NOT EXISTS empregado(
	primeiro_nome 		varchar(30) NOT NULL,
	iniciais_sobrenome	varchar (10),
	ultimo_nome 		varchar(30) NOT NULL,
	cpf 				char(14) NOT NULL PRIMARY KEY,
	data_nascimento 	date NOT NULL,
	endereco 			varchar(30),
	genero 				enum ('M','F','X') NOT NULL,
	salario 			decimal(10,2) NOT NULL,
	supervisor_cpf 		char(14) NULL,
	departamento_numero int NOT NULL,
	CONSTRAINT chk_salario_empregado CHECK (salario >= 2000.0)
);

CREATE TABLE IF NOT EXISTS departamento(
	departamento_nome 			varchar(20) NOT NULL UNIQUE,
	departamento_numero 		int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	data_criacao_departamento	date NOT NULL,
	gerente_cpf 				char(14) NOT NULL,
	data_inicio_gerente 		date NOT NULL,
	CONSTRAINT chk_inicio_gerente_criacao_departamento 
		CHECK (data_criacao_departamento < data_inicio_gerente),
	FOREIGN KEY (gerente_cpf) REFERENCES empregado(cpf)
);

CREATE TABLE IF NOT EXISTS departamento_localizacao(
	departamento_numero 		int NOT NULL,
	departamento_localizacao 	varchar(20) NOT NULL,
	PRIMARY KEY (departamento_numero, departamento_localizacao),
	FOREIGN KEY (departamento_numero) REFERENCES departamento (departamento_numero)
);

CREATE TABLE IF NOT EXISTS projeto(
	projeto_nome 		varchar(20) NOT NULL UNIQUE,
	projeto_numero 		int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	projeto_localizacao varchar(20),
	departamento_numero int NOT NULL,
	FOREIGN KEY (departamento_numero) REFERENCES departamento (departamento_numero)
);

CREATE TABLE IF NOT EXISTS alocado(
	empregado_cpf 	char(14) NOT NULL,
	projeto_numero 	int NOT NULL,
	hora_alocado 	decimal(3,1) NOT NULL,
	PRIMARY KEY (empregado_cpf, projeto_numero),
	FOREIGN KEY (empregado_cpf) REFERENCES empregado (cpf),
	FOREIGN KEY (projeto_numero) REFERENCES projeto (projeto_numero)
);

CREATE TABLE IF NOT EXISTS dependente(
	empregado_cpf 	char(14) NOT NULL,
	dependente_nome varchar(60) NOT NULL,
	genero 			enum ('M','F','X') NOT NULL,
	data_nascimento	date NOT NULL,
	parentesco		varchar(20) NOT NULL,
	PRIMARY KEY (empregado_cpf, dependente_nome),
	FOREIGN KEY (empregado_cpf) REFERENCES empregado (cpf)
);

SHOW tables;
