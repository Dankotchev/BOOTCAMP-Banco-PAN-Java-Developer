package com.dio.danilo.bootcamp;

import com.dio.danilo.bootcamp.model.Bootcamp;
import com.dio.danilo.bootcamp.model.Curso;
import com.dio.danilo.bootcamp.model.Dev;
import com.dio.danilo.bootcamp.model.Mentoria;

public class Principal {

    public static void main(String[] args) {
        Curso curso1 =  new Curso();
        Curso curso2 =  new Curso();
        Mentoria mentoria1 = new Mentoria();
        Mentoria mentoria2 = new Mentoria();
        
        // Criação dos cursos e mentorias
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Curso de Java Básico");
        curso1.setCargaHoraria(30);
        
        curso2.setTitulo("Curso Python");
        curso2.setDescricao("Curso de Python Avançado");
        curso2.setCargaHoraria(60);

        mentoria1.setTitulo("Mentoria de Abertura");
        mentoria1.setDescricao("A primeira mentoria do Bootcamp");
        
        mentoria2.setTitulo("Mentoria de Encerramento");
        mentoria2.setDescricao("A última mentoria do Bootcamp");
        
        // Criação do Bootcamp
        Bootcamp bootcamp = new Bootcamp("Banco Pan Java Developer", "O primeiro programa do Banco PAN em parceria com a DIO chega com uma trilha completa em Java Spring Boot.");
        
        mentoria1.setDataMonitoria(bootcamp.getDataInicial().plusDays(7));
        mentoria2.setDataMonitoria(bootcamp.getDataFinal().minusDays(10));
        
        bootcamp.getListaConteudo().add(curso1);
        bootcamp.getListaConteudo().add(curso2);
        bootcamp.getListaConteudo().add(mentoria1);
        bootcamp.getListaConteudo().add(mentoria2);
        
        
        // Criação dos Devs que participaram do bootcamp
        Dev devDanilo = new Dev("Danilo");
        Dev devTereza = new Dev("Tereza");
        
        // Inscrever no bootcamp
        devDanilo.inscreverNoBootcamp(bootcamp);
        devTereza.inscreverNoBootcamp(bootcamp);
        
        // Progredir no bootcamp
        devDanilo.progredir();
        devTereza.progredir();
        devDanilo.progredir();
        
        // Conteudos inscritos e concluídos
        System.out.println("Conteúdo inscritos de Danilo: " + devDanilo.getListaConteudosInscritos());
        System.out.println("Conteúdo concluídos de Danilo: " + devDanilo.getListaConteudosConcluidos());
        System.out.println("XP de Danilo: " + devDanilo.calcularTotalXP());
        
        System.out.println("");
        
        System.out.println("Conteúdo inscritos de Tereza: " + devTereza.getListaConteudosInscritos());
        System.out.println("Conteúdo concluídos de Tereza: " + devTereza.getListaConteudosConcluidos());
        System.out.println("XP de Tereza: " + devTereza.calcularTotalXP());
        
        
        // Devs inscritos no bootcamp
        System.out.println("\nDevs inscritos no " + bootcamp.getNome() + ": " + bootcamp.getDevsInscritos());
        
        
    }
}
