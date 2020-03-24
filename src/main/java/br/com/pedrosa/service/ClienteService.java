package br.com.pedrosa.service;

import br.com.pedrosa.model.Cliente;
import br.com.pedrosa.repository.ClienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public List<Cliente> listAll() {
        //return Cliente.listAll(); //caso queira usar metodo da entidade
        return clienteRepository.listAll();
    }


    public List<Cliente> search(String nome) {
        return clienteRepository.findByNome(nome);
    }


    public Cliente getById(Long id) {
        return clienteRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Cliente nao encontrado",404));
    }

    @Transactional
    public Cliente update(Long id, Cliente cliente){
        return clienteRepository.findByIdOptional(id)
                .map(existente -> {
                    existente.idade = cliente.idade;
                    existente.nome =  cliente.nome;
                    clienteRepository.persist(existente);
                    return existente;
                })
                .orElseThrow(() -> new WebApplicationException("Cliente nao encontrado",404));
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        clienteRepository.persist(cliente);
        return cliente;
    }

    @Transactional
    public void deleteById(Long id) {
        Cliente cliente = clienteRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Cliente nao encontrado",404));
        clienteRepository.delete(cliente);
    }
}
