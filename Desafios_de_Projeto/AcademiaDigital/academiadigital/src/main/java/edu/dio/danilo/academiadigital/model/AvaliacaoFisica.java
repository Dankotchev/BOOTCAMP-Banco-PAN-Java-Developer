package edu.dio.danilo.academiadigital.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "avaliacao_fisica")
public class AvaliacaoFisica {
    @Id
    @Column(name = "id_avaliacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column(name = "data_avaliacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dataAvaliacao = LocalDate.now();

    @Column(name = "peso_atual", nullable = false)
    private Double peso;

    @Column(name = "altura_atual", nullable = false)
    private Double altura;
}
