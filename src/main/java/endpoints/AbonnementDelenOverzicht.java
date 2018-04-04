package endpoints;

import dao.GebruikerDAO;
import responses.AbonnementId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/abonnees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AbonnementDelenOverzicht {

    @Inject
    GebruikerDAO gebruikerDAO;

    @Path("")
    @GET
    public Response toonAlleAndereAbonneesBehalveMij(@QueryParam("token") String token) {
        return Response.ok().entity(gebruikerDAO.toonAlleAbonneesBehalveMij(token)).build();
    }

    @Path("/{id}")
    @POST
    public Response deelAbonnementMetIemandAnders(@PathParam("id") int idAbonnee, AbonnementId abonnementId, @QueryParam("token") String token) {

        gebruikerDAO.deelAbonnementMetIemandAnders(idAbonnee, abonnementId.getId(), token);
        return Response.ok().build();

    }
}
