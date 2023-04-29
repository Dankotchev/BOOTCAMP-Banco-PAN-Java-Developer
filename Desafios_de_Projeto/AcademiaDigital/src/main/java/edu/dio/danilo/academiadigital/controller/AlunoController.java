package edu.dio.danilo.academiadigital.controller;

import edu.dio.danilo.academiadigital.model.Aluno;
import edu.dio.danilo.academiadigital.model.AvaliacaoFisica;
import edu.dio.danilo.academiadigital.model.form.AlunoForm;
import edu.dio.danilo.academiadigital.service.impl.AlunoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataNascimento", required = false) String dataNacimento) {
        return service.getAll(dataNacimento);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }
}
