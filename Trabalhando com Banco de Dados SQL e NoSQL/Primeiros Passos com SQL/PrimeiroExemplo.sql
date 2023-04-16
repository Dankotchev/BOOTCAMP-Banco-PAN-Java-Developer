-- DROP DATABASE IF EXISTS primeiro_exemplo;
CREATE DATABASE IF NOT EXISTS primeiro_exemplo;
USE primeiro_exemplo;
SHOW tables;

CREATE TABLE IF NOT EXISTS pessoa(
	pessoa_id SMALLINT UNSIGNED AUTO_INCREMENT,
	primeiro_nome varchar(20),
	ultimo_nome varchar(20),
	genero enum(
		'M',
		'F'
	),
	data_nascimento date,
	logradouro varchar(20),
	cidade varchar(20),
	estado varchar(20),
	pais varchar (20),
	codigo_postal varchar(20),
	CONSTRAINT pk_pessoa PRIMARY KEY (pessoa_id)
);

CREATE TABLE IF NOT EXISTS comida_favorita(
	pessoa_id SMALLINT UNSIGNED,
	comida varchar (20),
	CONSTRAINT pk_comida_favorita PRIMARY KEY (
		pessoa_id,
		comida
	),
	CONSTRAINT fk_comida_favorita_pessoa_id FOREIGN KEY (pessoa_id)
		REFERENCES pessoa(pessoa_id)
);

INSERT INTO pessoa (primeiro_nome, ultimo_nome, genero, data_nascimento, logradouro, cidade, estado, pais, codigo_postal) VALUES 
('Danilo', 'Quirino', 'M', '1996-06-27', 'Rua Natal', 'Presidente Epitácio', 'SP', 'Brasil', '19470-000'),
('Daniele', 'Quirino', 'F', '1999-08-24', 'Rua Natal', 'Presidente Epitácio', 'SP', 'Brasil', '19470-000'),
('Tereza', 'Quirino', 'F', '1963-06-15', 'Rua Natal', 'Presidente Epitácio', 'SP', 'Brasil', '19470-000');

SELECT * FROM pessoa;

INSERT INTO comida_favorita VALUES (1, 'Lasanha'), (2, 'Pastel de Calabresa'), (3, 'Salada de Batata'), (1, 'Mandioca Frita'), (3, 'Macarrão');

SELECT * FROM comida_favorita;