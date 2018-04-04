package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginAndTokenTest {


    private Abonnee abonnee;
    private LoginAndToken loginAndToken;
    private String token = "2323-1313-1414";
    private int id = 5;
    private String naam = "Georginio Vivaldo";
    private String email = "GioVivo@gmail.com";


    @Before
    public void init(){

        abonnee = new Abonnee(5, "Georginio Vivaldo","GioVivo@gmail.com");
        loginAndToken = new LoginAndToken(abonnee,"2323-1313-1414" );
    }


    @Test
    public void testLoginAndTokenReturnGebruikersnaam(){
        assertEquals(naam, loginAndToken.getGebruikersnaam());
    }


    @Test
    public void testLoginAndTokenReturnToken(){
        assertEquals(token, loginAndToken.getToken());
    }








}
