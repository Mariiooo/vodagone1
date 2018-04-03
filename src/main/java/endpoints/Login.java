package endpoints;


import dao.UserDAO;

import model.LoginAndToken;
import model.LoginRequest;
import responses.LoginResponse;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("login")
public class Login {

    @Inject
    UserDAO userDAO;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vodagoneLogin(LoginRequest loginUser) throws SQLException {

        LoginAndToken loginAndToken = userDAO.getNewUser(loginUser.getUser(), loginUser.getPassword());

        if (loginAndToken == null) {
            return Response
                    .status(401)
                    .build();


        }
        return Response
                .ok()
                .entity(new LoginResponse(loginAndToken))
                .build();

    }
}
