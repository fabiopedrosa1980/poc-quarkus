package br.com.pedrosa.repository;

import br.com.pedrosa.model.Cliente;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Cliente> list() {
        return entityManager.createQuery("select c from Cliente c").getResultList();
    }

    public Cliente getById(Long id) {
        return entityManager.find(Cliente.class,id);
    }

    @Transactional
    public Cliente update(Long id, Cliente cliente){
        Cliente existed = getById(id);
        existed.setNome(cliente.getNome());
        existed.setIdade(cliente.getIdade());
        entityManager.persist(existed);
        return existed;
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public void deleteById(Long id) {
        Cliente c = getById(id);
        entityManager.remove(c);
    }

}
