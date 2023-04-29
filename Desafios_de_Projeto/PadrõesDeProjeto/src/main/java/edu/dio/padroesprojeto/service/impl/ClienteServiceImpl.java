package edu.dio.padroesprojeto.service.impl;

import edu.dio.padroesprojeto.model.Cliente;
import edu.dio.padroesprojeto.model.Endereco;
import edu.dio.padroesprojeto.repository.ClienteRepository;
import edu.dio.padroesprojeto.repository.EnderecoRepository;
import edu.dio.padroesprojeto.service.ClienteService;
import edu.dio.padroesprojeto.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public void inserir(Cliente cliente) {
        savarClientePorCEP(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBanco = clienteRepository.findById(id);
        if (clienteBanco.isPresent())
            savarClientePorCEP(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void savarClientePorCEP(Cliente cliente) {
        // Verificar se existe o endereço do cliente
        Endereco endereco = enderecoRepository
                .findById(cliente.getEndereco().getCep())
                .orElseGet(() -> {
                    // Caso o endereço não exista, executa uma Lambda, usando ViaCEP e salvando no banco de dados
                    return enderecoRepository
                            .save(viaCepService
                                    .consultarCep(cliente.getEndereco().getCep()));
                });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
