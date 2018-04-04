package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginRequestTest {

    private LoginRequest loginRequest;
    private String user = "testUser";
    private String password = "pass123Test";


    @Before
    public void init(){
       loginRequest = new LoginRequest("testUser", "pass123Test");
    }

    @Test
    public void loginRequestToontGebruiker(){
        assertEquals(user, loginRequest.getUser());
    }

    @Test
    public void loginRequestToontWachtwoord(){
        assertEquals(password, loginRequest.getPassword());
    }

}
