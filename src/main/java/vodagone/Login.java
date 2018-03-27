package vodagone;


import dao.UserDAO;
import dto.LoginRequest;
import dto.LoginResponse;
import model.Token;
import model.User;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/login")
public class Login {

    @Inject
    UserDAO userDAO;
    User users;


    @POST
    public Response vodagoneLogin(LoginRequest user){
        Token token = new Token();


       // (user.getUser().equals(userDAO.getUsername(users.getId())) && user.getPassword().equals(userDAO.getPassword(users.getId()))

      //  Osoba ktora sie loguje czy jest to ta sama co jest w bazie danych..!

        if (user.getUser().equals(userDAO.getUsername(1)) && user.getPassword().equals(userDAO.getPassword(1)))
        {
            System.out.println(userDAO.getUsername(1));
            System.out.println(userDAO.getPassword(1));

            return Response.ok(new LoginResponse(token.getToken(), user.getUser())).build();


        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }


}
