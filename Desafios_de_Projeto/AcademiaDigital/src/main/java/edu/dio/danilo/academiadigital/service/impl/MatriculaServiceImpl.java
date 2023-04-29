package edu.dio.danilo.academiadigital.service.impl;

import edu.dio.danilo.academiadigital.model.Aluno;
import edu.dio.danilo.academiadigital.model.Matricula;
import edu.dio.danilo.academiadigital.model.form.MatriculaForm;
import edu.dio.danilo.academiadigital.repository.AlunoRepository;
import edu.dio.danilo.academiadigital.repository.MatriculaRepository;
import edu.dio.danilo.academiadigital.service.interfaces.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null)
            return matriculaRepository.findAll();
        else
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }
}
