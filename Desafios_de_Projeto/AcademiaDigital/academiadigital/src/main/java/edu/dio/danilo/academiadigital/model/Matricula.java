package edu.dio.danilo.academiadigital.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @Column(name = "id_matricula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column(name = "data_matricula", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dataMatricula = LocalDate.now();
}
