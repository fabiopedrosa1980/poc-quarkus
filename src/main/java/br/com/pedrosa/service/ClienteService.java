package br.com.pedrosa.service;

import br.com.pedrosa.model.Cliente;
import br.com.pedrosa.repository.ClienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public List<Cliente> list() {
        return clienteRepository.list();
    }

    public Cliente getById(Long id) {
        return clienteRepository.getById(id);
    }

    @Transactional
    public Cliente update(Long id, Cliente cliente){
        return clienteRepository.update(id,cliente);
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
