![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white "Java")    ![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide)

# Trabalhando com Collections Java

Resolução de exemplos e exercícios propostos do curso "Trabalhando com Collections Java"

## List

Compreendendo métodos da interface List e comparações através das implementações Comparator e Comparable

### Descrição dos Exercícios Propostos

- [Temperatura Média:](src\edu\dio\danilo\collections\list\exercicios\TemperaturaMedia.java)
  
  Faça um programa que receba e armazene a temperatura média dos 6 primeiro meses do ano e armazene-as em uma lista. 
  
  Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média, em que mês elas ocorreram (mostrar o mês por extenso: 1 - Janeiro, 2 - Fevereiro e etc).

- [Investigação:](src\edu\dio\danilo\collections\list\exercicios\Investigacao.java)
  
  Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
  
  1. "Telefonou para a vítima?"  
  2. "Esteve no local do crime?"  
  3. "Mora perto da vítima?"  
  4. "Devia para a vítima?"  
  5. "Já trabalhou com a vítima?"
  
  Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como "Assassina". Caso contrário ela será classificada com "Inocente".

## Set
Compreendendo métodos da interface Set e comparações através das implementações Comparator e Comparable

### Descrição dos Exercícios Propostos

- [Arco-Iris:](src\edu\dio\danilo\collections\set\exercicios\Arcoiris.java)

Crie um conjunto contendo as cores do arco-íris e :

* Exibia todas as cores uma abaixo da outra;
* A quantidade de cores que o arco-íris têm;
* Exiba as cores em ordem alfabética;
* Exiba as cores em ordem inversa da que foi informada;
* Exiba todas as cores que começam com a letra "v";
* Remova todas as cores que começam com a çetra "v";
* Limpe o conjunto;
* Confira se o conjunto está vazio.

- [Linguagem Favorita:](src\edu\dio\danilo\collections\set\exercicios\LinguagemFavorita.java)

Crie uma classe Linguagem que possua os atributos nome, anoDeCriacao e ide. Em seguida, crie um conjunto de linguagens e faça um programa que ordene esse conjunto por:

* Ordem de inserção;
* Ordem natural (nome);
* IDE;
* Ano de criação e nome;
* Nome, ano de criação e IDE.

Ao final, exiba as linguagens no conole, uma abaixo da outra.

## Map

- [População](src\edu\dio\danilo\collections\Map\exercicios\População.java):

Dada a população estimada de alguns estados do nordeste brasileiro, faça:
Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265

* Crie um dicionário e relacione os estados e suas populações
* Substitua a populção do estado do RN por 3.534.165
* Confira se o estado PB está no dicionário, caso não adcione PE - 4.039.277
* Exiba a população do PE
* Exiba todos os estados e suas populações na ordem em que foram informados
* Exiba os estados e suas populações em ordem alfabética
* Exiba o estado com a menor população
* Exiba o estado com a maior população
* Exiba a soma populacional desses estados
* Exiba a média populacional desses estados
* Remova os estados com população menor do que 4.000.000
* Apague o dicionário de estados
* Confira se o dicionário está vazio

- [Lançamento de Dados](src\edu\dio\danilo\collections\Map\exercicios\LancamentoDado.java):

Faça um programa que simule o lançamento de dados. Lance o dado 100 vezes e armazene. Depois mostre quantas vezes cada valor foi inserido.