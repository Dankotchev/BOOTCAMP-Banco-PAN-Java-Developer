package edu.dio.danilo.academiadigital.service.impl;

import edu.dio.danilo.academiadigital.model.Aluno;
import edu.dio.danilo.academiadigital.model.AvaliacaoFisica;
import edu.dio.danilo.academiadigital.model.form.AvaliacaoFisicaForm;
import edu.dio.danilo.academiadigital.model.form.AvaliacaoFisicaUpdateForm;
import edu.dio.danilo.academiadigital.repository.AlunoRepository;
import edu.dio.danilo.academiadigital.repository.AvaliacaoFisicaRepository;
import edu.dio.danilo.academiadigital.service.interfaces.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoRepository.findById(id).get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacao = avaliacaoRepository.findById(id).get();
        avaliacao.setAltura(formUpdate.getAltura());
        avaliacao.setPeso(formUpdate.getPeso());
        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    public void delete(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}
