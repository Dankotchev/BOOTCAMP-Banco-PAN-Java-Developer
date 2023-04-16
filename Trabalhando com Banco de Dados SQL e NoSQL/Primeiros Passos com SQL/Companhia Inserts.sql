USE dio_companhia;

INSERT INTO empregado 
	(
		primeiro_nome,
		ultimo_nome,
		cpf,
		data_nascimento,
		genero,
		salario,
		supervisor_cpf,
		departamento_numero
	)
VALUES
	('Danilo', 'Quirino', '258.147.369-25', '1996-06-27', 'M', 3600, NULL, 1),
	('Daniele', 'Quirino', '548.369.754-30', '1999-08-24', 'F', 3000, '258.147.369-25', 1),
	('Tereza', 'Quirino', '321.654.987-25', '1963-09-15', 'F', 3500, '258.147.369-25', 2),
	('Antonio', 'Souza', '787.698.555-66', '2000-01-25', 'M', 2500, '321.654.987-25', 2),
	('João', 'Castanho', '547.888.999-55', '1995-04-30', 'M', 2900, '321.654.987-25', 2),
	('Elena', 'Guz', '777.888.258-55', '1985-04-30', 'F', 2140, '258.147.369-25', 1),
	('Maria', 'Lopes', '777.658.999-55', '1990-04-30', 'F', 4000, '258.147.369-25', 1);
	
INSERT INTO dependente VALUES ('777.888.258-55', 'Carla Guz', 'F', '2020-05-20', 'filho');

INSERT INTO departamento VALUES 
	('Pesquisa', 1, '1980-02-10', '258.147.369-25','2020-01-01' ),
	('Administração', 2, '1980-02-10', '321.654.987-25', '2020-01-01' );
	
INSERT INTO departamento_localizacao VALUES (1, 'São Paulo'), (2, 'São Paulo');

INSERT INTO projeto 
	(
		projeto_nome,
		projeto_localizacao,
		departamento_numero
	) 
VALUES
	('Produto X', 'São Paulo', 1),
	('Produto G', 'São Paulo', 1),
	('Redução de custos', 'São Paulo', 2);

INSERT INTO alocado VALUES 
	('258.147.369-25', 1, 10.0),
	('258.147.369-25', 2, 30.0),
	('548.369.754-30', 2, 40.0),
	('321.654.987-25', 3, 40.0);
	
	
SELECT * FROM empregado;