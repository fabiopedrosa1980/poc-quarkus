package br.com.pedrosa.repository;

import br.com.pedrosa.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Stream;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public Stream<Cliente> findByNome(String nome){
        return find("nome",nome).stream();
    }
}
