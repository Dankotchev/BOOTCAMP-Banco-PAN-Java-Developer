package edu.dio.danilo.academiadigital.service.impl;

import edu.dio.danilo.academiadigital.infra.util.JavaTimeUtils;
import edu.dio.danilo.academiadigital.model.Aluno;
import edu.dio.danilo.academiadigital.model.AvaliacaoFisica;
import edu.dio.danilo.academiadigital.model.form.AlunoForm;
import edu.dio.danilo.academiadigital.model.form.AlunoUpdateForm;
import edu.dio.danilo.academiadigital.repository.AlunoRepository;
import edu.dio.danilo.academiadigital.service.interfaces.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataNascimento(form.getDataNascimento());
        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll(String dataNascimento) {
        if (dataNascimento == null)
            return repository.findAll();
        else
            return repository.findByDataNascimento(
                    LocalDate.parse(dataNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER));
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm form) {
        Aluno aluno = repository.findById(id).get();
        aluno.setNome(form.getNome());
        aluno.setBairro(form.getBairro());
        aluno.setDataNascimento(form.getDataNascimento());
        return repository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        return repository.findById(id)
                .get()
                .getAvaliacoes();
    }
}
