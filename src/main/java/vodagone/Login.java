package vodagone;

import model.Token;
import model.User;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/")
public class Login {

    private String jsonUser;
    private String jsonPassword;


//            System.out.println("loggedin");

    @Path("login")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response vodagoneLogin(User user) {
        System.out.println(user.getUser());
//        jsonUser = Json.getString("user");
//        jsonPassword = Json.getString("password");
//        System.out.println(jsonUser + "  " + jsonPassword);
//        if (jsonUser.equals(User.getUsername()) && jsonPassword.equals(User.getPassword())) {
//            JsonObject.add("token", User.getToken());
//            JsonObject.add("user", "Meron Brouwe
        Token token = new Token();
        token.setToken("242-242-24");
        token.setUser("Meron");
            return Response.ok(token).build();

    }


}

