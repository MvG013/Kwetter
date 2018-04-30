package boundary.rest;

import domain.*;
import service.AccountService;
import service.KweetService;
import service.ProfileService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;


@Path("kweets")
@Stateless
public class KweetResponse {

    @Inject
    private AccountService accountService;

    @Inject
    private KweetService kweetService;

    @Inject
    private ProfileService profileService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllKweets() {
        List<Kweet> kweetList = kweetService.getAll();
        return Response.ok(kweetService.convertAllToJson(kweetList)).header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createKweet(Kweet kweet) {
        if (kweet == null) {
            return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
        }
        kweet.setPostTime(new Date());
        kweet.setSender(profileService.findById(kweet.getSender().getId()));
        kweetService.save(kweet);
        return Response.ok().header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("find/{message}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllKweetsByMessage(@PathParam("message") String message) {
        List<Kweet> kweetList = kweetService.findAllKweetsByMessage(message);
        if (kweetList != null) {
            return Response.ok(kweetService.convertAllToJson(kweetList)).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("hashtag/{subject}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllKweetsByHashtagSubject(@PathParam("subject") String subject) {
        List<Kweet> kweetList = kweetService.findAllKweetsByHashtagSubject(subject);
        if (kweetList != null) {
            return Response.ok(kweetService.convertAllToJson(kweetList)).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("timeline/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeline(@PathParam("id") Long id) {

        if (id == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        Profile foundProfile = this.profileService.findById(id);
        if (foundProfile == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        List<Kweet> timelineKweets = this.kweetService.findAllKweetsFromFollowing(foundProfile);
        return Response.ok(this.kweetService.convertAllToJson(timelineKweets)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllKweetsByUser(@PathParam("id") Long senderId) {
        List<Kweet> kweetList = kweetService.findAllKweetsBySender(senderId);
        if (kweetList != null) {
            return Response.ok(kweetService.convertAllToJson(kweetList)).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        Kweet kweet = kweetService.findById(id);
        if (kweet != null) {
            return Response.ok(kweet.toJson()).header("Access-Control-Allow-Origin", "*").build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id) {
        kweetService.deleteById(id);
        return Response.ok().header("Access-Control-Allow-Origin", "*").build();
    }
}