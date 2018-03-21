package vodagone;


import model.Abonnement;
import model.Abonnementen;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("")
public class AbonnementenOverzicht {

    @GET
    @Path("/abonnementen")
    @Produces("application/json")
    @Consumes("application/json")
    public Response showAbonnementen() {


        Abonnementen testabbo = new Abonnementen();
        testabbo.addAbonnement(new Abonnement(0, "vodafone", "Mobiele telefonie 100"));
        testabbo.addAbonnement(new Abonnement(1, "vodafone", "Mobiele telefonie 250"));
        testabbo.addAbonnement(new Abonnement(2, "ziggo", "Kabel-internet (download 300 Mbps"));

        return Response.ok(testabbo).build();

    }


    @POST
    @Path("/abonnementen")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addAbonnementen(@QueryParam("token") String token) {

        Abonnementen testabbo = new Abonnementen();
        testabbo.addAbonnement(new Abonnement(3, "vodafone", "Glasvezel-internet (download 500 Mbps)"));

        return Response.ok(testabbo).build();

    }


//    @GET
//    @Path("{token}")
//    @Consumes("application/json")
//    public Response showAllAbonnementen(Abonnementen abonnementen, @PathParam("token") String token) {
//        return Response.ok(abonnementen).build();
//
//    }
//
//
//
//    @POST
//    @Path("/abonnementen")
//    @Consumes("application/json")
//    public Response addAbonnement(@QueryParam("id") String id) {
//
//        return Response.ok().build();
//
//
//    }

}
