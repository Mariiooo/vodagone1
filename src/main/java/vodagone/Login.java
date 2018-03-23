package vodagone;


import dto.LoginRequest;
import dto.LoginResponse;
import model.Token;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/login")
public class Login {


    @POST
    public Response vodagoneLogin(LoginRequest user){
        Token token = new Token();

        if (user.getUser().equals(user.getUser()) && user.getPassword().equals(user.getPassword())) {
            return Response.ok(new LoginResponse(token.getToken(), user.getUser())).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }


}
