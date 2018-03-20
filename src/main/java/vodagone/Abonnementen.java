package vodagone;


import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("")
public class Abonnementen {

    @Path("/abonnementen")
    @GET
    @Produces("application/json")
    public Response AbonnementenList() {

        JsonObject abonnementen = Json.createObjectBuilder()

                .add("abonnementen", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("id", 0)
                                .add("aanbieder", "vodafone")
                                .add("dienst", "Mobiele telefonie 100")
                        )
                        .add(Json.createObjectBuilder()
                                .add("id", 1)
                                .add("aanbieder", "vodafone")
                                .add("dienst", "Mobiele telefonie 250")
                        )
                        .add(Json.createObjectBuilder()
                                .add("id", 2)
                                .add("aanbieder", "ziggo")
                                .add("dienst", "Kabel-internet (download 300 Mbps")))
                .add("totalprijs", 42.37)

                .build();

        return Response.ok(abonnementen)
                .build();
    }


    @Path("")
    public Response showAbonnementen(@QueryParam("token") String token) {
        return Response.ok().build();

    }

    @Path("")
    @POST
    public Response addAbonnement(@QueryParam("id") String id) {

        return Response.ok().build();


    }

}
