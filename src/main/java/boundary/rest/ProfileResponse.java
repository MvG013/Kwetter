package boundary.rest;

import domain.Profile;
import service.ProfileService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/profiles")
@Stateless
public class ProfileResponse {

    @Inject
    private ProfileService profileService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        GenericEntity entity = new GenericEntity<List<Profile>>(profileService.findAll()) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findById(@QueryParam("senderId") Long id) {
        Profile profile = profileService.findById(id);
        if (profile == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(profile).build();
    }
}