package br.com.pedrosa.resource;

import br.com.pedrosa.model.Cliente;
import br.com.pedrosa.service.ClienteService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Cliente> list() {
            return clienteService.list();
    }

}