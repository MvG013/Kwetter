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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUserProfiles() {
        List<Profile> userProfiles = profileService.findAll();
        return Response.ok((profileService.convertAllToJson(userProfiles))).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserProfileById(@PathParam("id") Long id) {
        Profile userProfile = profileService.findById(id);
        if (userProfile != null) {
            return Response.ok(userProfile.toJson()).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("find/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserProfileByUsername(@PathParam("username") String username) {
        Profile userProfile = profileService.findByUsername(username);
        if (userProfile != null) {
            return Response.ok(userProfile.toJson()).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("find/followers/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFollowers(@PathParam("username") String username) {
        Profile userProfile = profileService.findByUsername(username);
        if (userProfile != null) {
            List<Profile> followers = userProfile.getFollowers();
            return Response.ok(profileService.convertAllToJson(followers)).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("find/following/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFollowing(@PathParam("username") String username) {
        Profile userProfile = profileService.findByUsername(username);
        if (userProfile != null) {
            List<Profile> followers = userProfile.getFollowing();
            return Response.ok(profileService.convertAllToJson(followers)).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countAllUserProfiles() {
        return Response.ok(profileService.countAll()).header("Access-Control-Allow-Origin", "*").build();
    }
}