package br.com.pedrosa.resource;

import br.com.pedrosa.model.Cliente;
import br.com.pedrosa.service.ClienteService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.Response.*;

@Path("/cliente")
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> list() {
        return clienteService.list();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getById(@PathParam("id") Long id) {
        return clienteService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Cliente save(@Valid Cliente cliente) {
        return clienteService.save(cliente);
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") final Long id, @Valid Cliente cliente) {
        clienteService.update(id,cliente);
        return ok().build();
    }

    @Path("{id}")
    @DELETE
    public Response deletePost(@PathParam("id") final String id) {
        this.clienteService.deleteById(id);
        return noContent().build();
    }

}