package edu.dio.danilo.collections.map;

import java.util.*;

public class Exemplo02OrdenadoMap {

    public static void main (String[] args) {
        Map<String, Livro> estante = new HashMap<>() {
            {
                put("Washington Irving", new Livro("A Lenda do Cavaleiro Sem Cabeca", 586));
                put("Eduardo Sphor", new Livro("A Batalha do Apocalipse", 192));
                put("Raphael Montes", new Livro("Suicídas", 432));

            }
        };

        // Ordem aleatória
        System.out.println("Apenas autor e livro aleatória");
        Set<Map.Entry<String, Livro>> entradas = estante.entrySet();
        for (Map.Entry<String, Livro> livro : entradas) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getTitulo());
        }

        // Ordem de inserção
        System.out.println("Ordem de inserção");
        Map<String, Livro> estante2 = new LinkedHashMap<>() {
            {
                put("Washington Irving", new Livro("A Lenda do Cavaleiro Sem Cabeca", 586));
                put("Eduardo Sphor", new Livro("A Batalha do Apocalipse", 192));
                put("Raphael Montes", new Livro("Suicídas", 432));

            }
        };
        for (Map.Entry<String, Livro> entrada2 : estante2.entrySet()) {
            System.out.println(entrada2.getKey() + " - " + entrada2.getValue().getTitulo());
        }

        // Ordem alfabética de autores
        System.out.println("Ordem alfabética de autores");
        Map<String, Livro> estante3 = new TreeMap<>(estante2);
        for (Map.Entry<String, Livro> entrada3 : estante3.entrySet()) {
            System.out.println(entrada3.getKey() + " - " + entrada3.getValue().getTitulo());
        }

        // Ordem alfabética dos títulos dos livro
        System.out.println("Ordem alfabética dos titulos");
        Set<Map.Entry<String, Livro>> estante4 = new TreeSet<>(new ComparatorNome());
        estante4.addAll(estante3.entrySet());
        for (Map.Entry<String, Livro> entrada4 : estante4) {
            System.out.println(entrada4.getKey() + " - "+entrada4.getValue().getTitulo());
        }

    }

}

class Livro implements Comparable<Livro> {

    private String titulo;
    private int paginas;

    //
    public Livro (String titulo, int paginas) {

        this.titulo = titulo;
        this.paginas = paginas;
    }

    public String getTitulo () {
        return titulo;
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas () {
        return paginas;
    }

    public void setPaginas (int paginas) {
        this.paginas = paginas;
    }

    @Override
    public int hashCode () {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.titulo);
        hash = 67 * hash + this.paginas;
        return hash;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Livro other = (Livro) obj;
        if (this.paginas != other.paginas)
            return false;
        return Objects.equals(this.titulo, other.titulo);
    }

    @Override
    public String toString () {
        return "Livro{" + "titulo=" + titulo + ", paginas=" + paginas + '}';
    }

    @Override
    public int compareTo (Livro other) {
        return this.getTitulo().compareToIgnoreCase(other.getTitulo());
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare (Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getTitulo().compareToIgnoreCase(l2.getValue().getTitulo());
    }

}
