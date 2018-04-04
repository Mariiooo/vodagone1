package endpoints;


import dao.GebruikerDAO;
import model.LoginAndToken;
import model.LoginRequest;
import responses.LoginResponse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class Login {

    @Inject
    GebruikerDAO gebruikerDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vodagoneLogin(LoginRequest loginUser){

        LoginAndToken loginAndToken = gebruikerDAO.maakNieuweGebruiker(loginUser.getUser(), loginUser.getPassword());

        if (loginAndToken == null) {
            return Response.status(401).build();
        }
        return Response.ok().entity(new LoginResponse(loginAndToken)).build();

    }
}
