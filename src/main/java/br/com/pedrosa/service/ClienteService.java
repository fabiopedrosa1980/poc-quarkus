package br.com.pedrosa.service;

import br.com.pedrosa.model.Cliente;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteService {

    public List<Cliente> list(){
        return List.of(
                new Cliente(1l,"Fabio",39),
                new Cliente(2l,"Maria",71))
                .stream()
                .collect(Collectors.toList());
    }
}
