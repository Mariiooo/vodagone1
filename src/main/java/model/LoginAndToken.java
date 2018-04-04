package model;

import dao.TokenDAO;

import java.sql.SQLException;

public class LoginAndToken {

    private Abonnee abonnee;
    private String token;

    public LoginAndToken(Abonnee abonnee, String token) {

        this.abonnee = abonnee;
        if (token == null) {
            this.createNewToken();
            return;
        }
        this.token = token;
    }

    public void createNewToken() {
        this.token = Token.generateToken();
        new TokenDAO().updateOrInsertUserToken(this.token, this.abonnee.getId());
    }


    public String getToken() {
        return token;
    }

    public String getGebruikersnaam() {
        return abonnee.getNaam();
    }
}
