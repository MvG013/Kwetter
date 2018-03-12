package boundary.rest;

import domain.Heart;
import service.HeartService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/hearts")
@Stateless
public class HeartResponseResource {

    @Inject
    private HeartService heartService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        GenericEntity entity = new GenericEntity<List<Heart>>(heartService.findAll()) {
        };
        return Response.ok(entity).build();
    }
}