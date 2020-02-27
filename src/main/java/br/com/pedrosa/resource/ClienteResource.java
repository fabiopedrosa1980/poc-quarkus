package br.com.pedrosa.resource;

import br.com.pedrosa.model.Cliente;
import br.com.pedrosa.service.ClienteService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.noContent;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
    public List<Cliente> list() {
        return clienteService.list();
    }

    @Path("{id}")
    @GET
    public Cliente getById(@PathParam("id") Long id) {
        return clienteService.getById(id);
    }

    @POST
    public Cliente save(@Valid Cliente cliente) {
        return clienteService.save(cliente);
    }

    @Path("{id}")
    @PUT
    public Cliente update(@PathParam("id") final Long id, @Valid Cliente cliente) {
        return clienteService.update(id,cliente);
    }

    @Path("{id}")
    @DELETE
    public Response delete(@PathParam("id") final Long id) {
        this.clienteService.deleteById(id);
        return noContent().build();
    }

}