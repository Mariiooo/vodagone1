package vodagone;


import dao.UserDAO;
import dto.LoginRequest;
import dto.LoginResponse;
import model.Token;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public class Login {

    @Inject
    UserDAO userDAO;

    @Path("login")
    @POST
    public Response vodagoneLogin(LoginRequest loginUser) {
        Token token = new Token();

        if (loginUser.getUser().equals(userDAO.getUsername(userDAO.getUserId(loginUser.getUser()))) &&
                loginUser.getPassword().equals(userDAO.getPassword(userDAO.getUserId(loginUser.getUser()))))

        {
            return Response.ok(new LoginResponse(token.getToken(), loginUser.getUser())).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }


}
