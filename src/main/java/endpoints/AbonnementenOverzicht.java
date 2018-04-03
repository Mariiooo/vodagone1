package endpoints;


import dao.AbonnementenDAO;
import responses.AbonnementenOverzichtGespecificeerd;
import responses.AbonnementenResponse;
import responses.DienstenOverzichtResponse;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/abonnementen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AbonnementenOverzicht {


    @Inject
    AbonnementenDAO abonnementenDAO;


    @Path("")
    @GET
    public Response toonAlleAbonnementenVanIngelogdeGebruiker(@QueryParam("token") String token) {
        return Response.ok().entity(new AbonnementenResponse(abonnementenDAO.alleAbonnementen(token))).build();
    }


    @Path("/{id}")
    @GET
    public Response toonAlleAbonnementenOpHunId(@PathParam("id") int id, @QueryParam("token") String token) {

        return Response.ok().entity(new AbonnementenOverzichtGespecificeerd(abonnementenDAO.alleAbonnementenPerId(token, id))).build();

    }

    @Path("")
    @POST
    public Response nieuweAbonnementenToevoegen(@QueryParam("token") String token, DienstenOverzichtResponse abonnementenToevoegenResponse) {

        abonnementenDAO.nieuweAbonnementenToevoegen(token, abonnementenToevoegenResponse.getIdDienst());
        return Response.ok().entity(new AbonnementenResponse(abonnementenDAO.alleAbonnementen(token))).build();


    }


    @Path("/{id}")
    @DELETE
    public Response bestaandeAbonnementenVerwijderen(@PathParam("id") int id, String token) {

        abonnementenDAO.abonnementenOpzeggen(id, token);
        return Response.ok().entity(new AbonnementenOverzichtGespecificeerd(abonnementenDAO.alleAbonnementenPerId(token, id))).build();


    }

    @Path("/{id}")
    @POST
    public Response bestaandeAbonnementenVerdubbellen(@PathParam("id") int id, String token) {

        abonnementenDAO.updateAbonnementenVerdubelling(id, token);
        return Response.ok().entity(new AbonnementenOverzichtGespecificeerd(abonnementenDAO.alleAbonnementenPerId(token, id))).build();

    }


}
