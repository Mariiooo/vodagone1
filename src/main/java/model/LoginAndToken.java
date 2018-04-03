package model;

import dao.TokenDAO;

import javax.inject.Inject;
import java.sql.SQLException;

public class LoginAndToken {

    private Abonnee abonnee;
    private String token;


    public LoginAndToken(Abonnee abonnee, String token) throws SQLException {

        this.abonnee = abonnee;
        if(token == null){
            this.createNewToken();
            return;
        }
        this.token = token;

    }

    public void createNewToken() throws SQLException {
        this.token = Token.generateToken();
       new TokenDAO().updateOrInsertUserToken(this.token, this.abonnee.getIdAbonnee());
    }


    public String getToken() {
        return token;
    }

    public String getGebruikersnaam() {
        return abonnee.getNaam();
    }



}
