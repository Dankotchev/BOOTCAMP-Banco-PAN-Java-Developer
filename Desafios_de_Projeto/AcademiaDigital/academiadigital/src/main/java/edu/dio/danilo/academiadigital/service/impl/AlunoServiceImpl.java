package edu.dio.danilo.academiadigital.service.impl;

import edu.dio.danilo.academiadigital.model.Aluno;
import edu.dio.danilo.academiadigital.model.AvaliacaoFisica;
import edu.dio.danilo.academiadigital.model.form.AlunoForm;
import edu.dio.danilo.academiadigital.model.form.AlunoUpdateForm;
import edu.dio.danilo.academiadigital.service.interfaces.AlunoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Override
    public Aluno create(AlunoForm form) {
        return null;
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        return null;
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        return null;
    }
}
