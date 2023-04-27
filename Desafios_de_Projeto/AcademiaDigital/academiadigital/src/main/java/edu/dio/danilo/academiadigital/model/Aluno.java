package edu.dio.danilo.academiadigital.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aluno")

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "bairro", length = 60)
    private String bairro;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
}
