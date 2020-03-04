package br.com.pedrosa.resource;

import br.com.pedrosa.model.Cliente;
import br.com.pedrosa.service.ClienteService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.noContent;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})
@Tag(name="Crud de Cliente")
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @Context
    UriInfo uriInfo;

    @GET
    @Operation(description = "Listar todos os clientes",summary = "Listar clientes")
    public List<Cliente> listAll() {
        return clienteService.listAll();
    }

    @Path("{id}")
    @GET
    @Operation(description = "Obter cliente por id",summary = "Obter cliente")
    public Cliente getById(@PathParam("id") Long id) {
        return clienteService.getById(id);
    }

    @POST
    @Operation(description = "Incluir cliente",summary = "Incluir cliente")
    public Response save(@Valid Cliente cliente) {
        clienteService.save(cliente);
        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", cliente.getId())
                .build();
        return created(location).entity(cliente).build();
    }

    @Path("{id}")
    @PUT
    @Operation(description = "Alterar o cliente do sistema",summary = "Altera cliente")
    public Cliente update(@PathParam("id") final Long id, @Valid Cliente cliente) {
        return clienteService.update(id,cliente);
    }

    @Path("{id}")
    @DELETE
    @Operation(description = "Excluir cliente por id",summary = "Exluir cliente")
    public Response delete(@PathParam("id") final Long id) {
        this.clienteService.deleteById(id);
        return noContent().build();
    }

}