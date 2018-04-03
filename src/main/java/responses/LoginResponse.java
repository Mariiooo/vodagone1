package responses;

import model.LoginAndToken;


public class LoginResponse {
    private String token;
    private String user;


    public LoginResponse(LoginAndToken loginAndToken) {
        this.user = loginAndToken.getGebruikersnaam();
        this.token = loginAndToken.getToken();

    }
}
