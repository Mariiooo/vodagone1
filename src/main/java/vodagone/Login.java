package vodagone;


import model.Token;
import model.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
public class Login {


    @Path("login")
    @POST
    public Response vodagoneLogin(User user){
        System.out.println(user.getUser());

        Token token = new Token();
        token.setToken("1234-1234-1234");
        token.setUser("meron");

            return Response.ok(token).build();
    }


}
