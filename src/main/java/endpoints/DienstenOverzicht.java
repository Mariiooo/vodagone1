package endpoints;

import dao.DienstDAO;
import model.Dienst;
import responses.DienstenOverzichtResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/abonnementen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DienstenOverzicht {

    @Inject
    DienstDAO dienstDAO;


    @Path("/all")
    @GET
    public Response toonAlleAbonnementenEnDienstenVanGebruiker(@QueryParam("token") String token, @QueryParam("filter") String filter){

        ArrayList<DienstenOverzichtResponse> dienstenOverzichtResponses = new ArrayList<>();

        for(Dienst dienst: dienstDAO.alleDienstenOverzicht()){
            if(dienst.getAanbieder().contains(filter) || dienst.getDienst().contains(filter))
                dienstenOverzichtResponses.add(new DienstenOverzichtResponse(dienst.getId(),  dienst.getAanbieder(), dienst.getDienst()));
        }
        return Response.ok().entity(dienstenOverzichtResponses).build();
    }

}
