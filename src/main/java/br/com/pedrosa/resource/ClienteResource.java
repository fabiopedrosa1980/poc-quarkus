package br.com.pedrosa.resource;

import br.com.pedrosa.dto.ClienteDTO;
import br.com.pedrosa.service.ClienteService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.noContent;

@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})
@Tag(name="Api de Clientes Apresentacao reload 2")
@Path("/clientes")
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
    @Operation(description = "Listar todos os clientes",summary = "Listar clientes ")
    public List<ClienteDTO> listAll() {
        return clienteService.listAll();
    }

    @GET
    @Path("{id}")
    @Operation(description = "Obter cliente por id",summary = "Obter cliente")
    public ClienteDTO getById(@PathParam("id") final Long id) {
        return clienteService.getById(id);
    }

    @POST
    @Operation(description = "Incluir cliente",summary = "Incluir cliente")
    public Response save(@Valid ClienteDTO cliente) {
        return Response.ok(clienteService.save(cliente)).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Operation(description = "Alterar o cliente do sistema",summary = "Altera cliente")
    public ClienteDTO update(@PathParam("id") final Long id, @Valid ClienteDTO cliente) {
        return clienteService.update(id,cliente);
    }

    @Path("{id}")
    @DELETE
    @Operation(description = "Excluir cliente por id",summary = "Exluir cliente")
    public Response delete(@PathParam("id") final Long id) {
        this.clienteService.deleteById(id);
        return noContent().build();
    }

    @GET
    @Path("search/{nome}")
    @Operation(description = "Pesquisar clientes por Nome",summary = "Pesquisar clientes por Nome")
    public List<ClienteDTO> search(@PathParam("nome") final String nome) {
        return clienteService.search(nome);
    }

}