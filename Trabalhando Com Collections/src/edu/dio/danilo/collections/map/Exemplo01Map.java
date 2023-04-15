package edu.dio.danilo.collections.map;

import java.util.*;


/*
    Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
        modelo = gol - consumo = 14,4km/l
        modelo = uno - consumo = 15,6 km/l
        modelo = mobi - consumo = 16,1 km/l
        modelo = hb20 - consumo = 14,5 km/l
        modelo = kwid - consumo = 15,6 km/l
 */
public class Exemplo01Map {

    public static void main (String[] args) {
        System.out.println( "Crie um dicionario que relaciona modelos e seus consumos" );
        Map<String, Double> carros = new HashMap<>() {
            {
                put( "gol", 14.4 );
                put( "uno", 15.6 );
                put( "mobi", 16.1 );
                put( "hb20", 14.5 );
                put( "kwid", 15.6 );
            }
        };

        // Para alterar, basta passar a chave e o novo valor para o value
        System.out.println( "Substituir o consumo do gol para 15.2 km/l" );
        carros.put( "gol", 15.2 );

        // Método containsKey verifica se tem a chave dentro do dicionário
        System.out.println( "Verificando se contem voyage? " + carros.containsKey( "voyage" ) );

        // Para retornar o valor de uma key, utiliza-se o get
        System.out.println( "O consumo do mobi eh: " + carros.get( "mobi" ) + " km/l" );

        // Para exibir os modelos, as keys, usa-se o metodo keySet, que retorna um Set dos objetos da chave
        System.out.println( "Os modelos disponiveis sao:" );
        Set<String> modelos = carros.keySet();
        for ( String modelo : modelos ) {
            System.out.println( "\t" + modelo );
        }

        // Para exibir os valores (values) usa-se o método values, retornando uma Collection
        System.out.println( "Os consumos dos carros sao:" );
        Collection<Double> consumos = carros.values();
        for ( Double consumo : consumos ) {
            System.out.println( "\t" + consumo + " km/l" );
        }

        // Retornar o mais valor entre os values, ou seja, o mais econômico
        //  Armazenar o maior value;
        Double consumoMaisEconomico = Collections.max( carros.values() );
        // Utilizar o entrySet para obter um Set que pode ser trabalhado
        Set<Map.Entry<String, Double>> entradas = carros.entrySet();

        for ( Map.Entry<String, Double> entrada : entradas ) {
            if ( entrada.getValue().equals( consumoMaisEconomico ) )
                System.out.println( "O modelo mais economico eh: " + entrada.getKey() + " - " + consumoMaisEconomico );
        }

        // Retonar o menor valor valor de consumo, ou seja, o menos eficiente
        Double consumoMenosEconomico = Collections.min( carros.values() );
        // Utilizar o entrySet para obter um Set que pode ser trabalhado
        entradas = carros.entrySet();

        for ( Map.Entry<String, Double> entrada : entradas ) {
            if ( entrada.getValue().equals( consumoMaisEconomico ) )
                System.out.println( "O modelo menos economico eh: " + entrada.getKey() + " - " + consumoMenosEconomico );
        }

        // Somar os values
        System.out.println( "A soma dos consumo eh: " + somaConsumo( carros ) );

        // Média dos values
        System.out.println( "A media dos consumos eh: " + ( somaConsumo( carros ) / carros.size() ) );

        // Removendo carros com consumo igual a 15.6
        Iterator<Double> iteratorRemove = carros.values().iterator();
        while ( iteratorRemove.hasNext() ) {
            Double next = iteratorRemove.next();
            if ( next.equals( 15.6 ) )
                iteratorRemove.remove();
        }
        
        // Apresentar por ordem de inserção, neste caso usando a implementação LinkedHashMap
        Map<String, Double> linkCarros = new LinkedHashMap<>(){
            {
                put( "gol", 14.4 );
                put( "uno", 15.6 );
                put( "mobi", 16.1 );
                put( "hb20", 14.5 );
                put( "kwid", 15.6 ); 
            }
        };
        
        
        // Apresentando em ordem alfabética dos modelos, por ordem crescente de chaves, usando o TreeMap
        Map<String, Double> treeCarros = new TreeMap<>(linkCarros);
        System.out.println( "Os modelos por ordem alfabetica" );
        System.out.println( treeCarros );
        
        // Apagar o dicionário
        carros.clear();
        
        // Verificando se ha itens
        System.out.println( "Dicionario esta vazio? "  + carros.isEmpty());

    }

    public static Double somaConsumo (Map<String, Double> map) {
        //Há possibilidade de chamar o iterator diretamente é pq o retorno do metodo values é um set
        Iterator<Double> iterator = map.values().iterator();
        Double somaConsumo = 0.0;
        while ( iterator.hasNext() ) {
            Double next = iterator.next();
            somaConsumo += next;
        }
        return somaConsumo;
    }
}
