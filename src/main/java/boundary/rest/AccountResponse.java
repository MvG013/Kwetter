package boundary.rest;

import domain.Account;
import service.AccountService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("accounts")
@Stateless
public class AccountResponse {

    @Inject
    private AccountService accountService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        GenericEntity entity = new GenericEntity<List<Account>>(accountService.findAll()) { };
        return Response.ok(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAccount(@PathParam("id") Long id) {
        Account account = accountService.findById(id);
        System.out.println(account);
        if (account == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(account).build();
    }

}
