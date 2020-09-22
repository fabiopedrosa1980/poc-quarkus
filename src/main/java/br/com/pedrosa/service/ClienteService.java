package br.com.pedrosa.service;

import br.com.pedrosa.config.ModelMapeprConfig;
import br.com.pedrosa.dto.ClienteDTO;
import br.com.pedrosa.model.Cliente;
import br.com.pedrosa.repository.ClienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    ModelMapeprConfig modelMapeprConfig;

    public List<ClienteDTO> listAll() {
        return clienteRepository.streamAll()
                .map(this::getClienteDTO)
                .collect(Collectors.toList());
    }

    public List<ClienteDTO> search(String nome) {
        return clienteRepository.findByNome(nome)
                .map(this::getClienteDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO getById(Long id) {
        return clienteRepository.findByIdOptional(id)
                .map(this::getClienteDTO)
                .orElseThrow(() -> new WebApplicationException("Cliente nao encontrado",404));
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO clienteDTO){
        return clienteRepository.findByIdOptional(id)
                .map(existente -> {
                    existente.idade = clienteDTO.getIdade();
                    existente.nome =  clienteDTO.getNome();
                    clienteRepository.persist(existente);
                    return getClienteDTO(existente);
                })
                .orElseThrow(() -> new WebApplicationException("Cliente nao encontrado",404));
    }

    @Transactional
    public ClienteDTO save(ClienteDTO clienteDTO) {
        var cliente = getCliente(clienteDTO);
        var c = new Cliente();
        clienteRepository.persist(cliente);
        return getClienteDTO(cliente);
    }

    @Transactional
    public void deleteById(Long id) {
        var cliente = clienteRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Cliente nao encontrado",404));
        clienteRepository.delete(cliente);
    }

    private ClienteDTO getClienteDTO(Cliente cliente){
        return modelMapeprConfig.modelMapper().map(cliente,ClienteDTO.class);
    }

    private Cliente getCliente(ClienteDTO clienteDTO){
        return modelMapeprConfig.modelMapper().map(clienteDTO,Cliente.class);
    }
}
