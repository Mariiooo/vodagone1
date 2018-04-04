package model;



import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GebruikerTest {

    private Gebruiker gebruiker;
    private String gebruikersnaam = "Mario";
    private String wachtwoord = "test";




    @Before
    public void init() {

        gebruiker = new Gebruiker("Mario", "test");

    }



    @Test
    public void testGebruikerToontGebruikersnaam(){
        assertEquals(gebruikersnaam, gebruiker.getGebruikersnaam() );
    }

    @Test
    public void testGebruikerToontWachtwoord(){
        assertEquals(wachtwoord, gebruiker.getWachtwoord());
    }


}
