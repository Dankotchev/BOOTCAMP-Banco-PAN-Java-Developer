USE dio_companhia;

-- Gerente e seus Departamentos
SELECT e.cpf, e.primeiro_nome, d.departamento_nome 
	FROM empregado e, departamento d
	WHERE (e.cpf = d.gerente_cpf);

-- Empregados e seus Departamentos
SELECT e.cpf, concat(upper(e.ultimo_nome) , ', ', e.primeiro_nome) AS 'Empregado', d.departamento_nome
	FROM empregado e, departamento d
	WHERE (e.departamento_numero = d.departamento_numero);


-- Empregados e seus Dependentes
SELECT e.cpf AS 'CPF Empregado', e.primeiro_nome AS 'Empregado', d.dependente_nome  AS 'Dependente', d.parentesco AS 'Grau de Parentensco'
	FROM empregado e , dependente d 
	WHERE (e.cpf = d.empregado_cpf);
	
-- Departamento especifico
SELECT d.departamento_nome, concat(upper(e.ultimo_nome) , ', ', e.primeiro_nome) AS 'Gerente', dl.departamento_localizacao AS 'Local'
	FROM departamento d 
		JOIN departamento_localizacao dl ON (d.departamento_numero = dl.departamento_numero)
		JOIN empregado e ON (d.gerente_cpf = e.cpf)
	WHERE d.departamento_numero = 2;
	
-- Funcionarios e seus Gerentes
SELECT concat(upper(e.ultimo_nome) , ', ', e.primeiro_nome) AS 'Empregado', concat(upper(g.ultimo_nome) , ', ', g.primeiro_nome) AS 'Gerente'
	FROM empregado e
		JOIN empregado g ON g.cpf = e.supervisor_cpf;
	
-- Empregados e suas alocações
SELECT concat(upper(e.ultimo_nome) , ', ', e.primeiro_nome) AS 'Empregado', p.projeto_nome AS 'Projeto', a.hora_alocado AS 'Tempo alocado'
	FROM empregado e
		JOIN alocado a ON (e.cpf = a.empregado_cpf)
		JOIN projeto p ON (a.projeto_numero = p.projeto_numero);
	

	