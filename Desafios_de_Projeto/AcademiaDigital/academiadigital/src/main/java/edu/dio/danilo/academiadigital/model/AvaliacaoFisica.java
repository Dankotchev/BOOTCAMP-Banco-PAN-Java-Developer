package edu.dio.danilo.academiadigital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "avaliacao_fisica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisica {
    @Id
    @Column(name = "id_avaliacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
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
