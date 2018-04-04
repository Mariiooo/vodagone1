package java.model;


import model.Abonnee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbonneeTest {

    private Abonnee abonnee;

    @Before
    public void init(){
        this.abonnee = new Abonnee(10, "Kevin", "KevinAlone@home.nl");
    }


    @Test
    public void moetIdTerugGeven(){

        assertEquals(10, abonnee.getId());
    }

    @Test
    public void moetNaamTerugGeven(){

        assertEquals("Kevin", abonnee.getNaam());
    }

    @Test
    public void moetEmailTerugGeven(){

        assertEquals("KevinAlone@home.nl", abonnee.getEmail());

    }


}
