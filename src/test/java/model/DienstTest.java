package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DienstTest {

    private Dienst dienst;
    private  int id = 1;
    private String dienstNaam = "HardcoreRadio Live";
    private int deelbaar = 1;
    private boolean verdubbelbaar = true;
    private String aanbieder = "vodafone";
    private double prijsPerMaand = 15.00;
    private final double DOUBLEDELTA = 0.001;

    @Before
    public void init() {

         dienst = new Dienst(1,"HardcoreRadio Live", 1, true, "vodafone", 15.00);

    }


    @Test
    public void testOfDienstIdToont(){
        assertEquals(id, dienst.getId()  );
    }

    @Test
    public void testOfDienstNaamTerugGeeft(){
        assertEquals(dienstNaam, dienst.getDienst());
    }

    @Test
    public void testOfDienstDeelbaarIs(){
        assertEquals(deelbaar, dienst.getDeelbaar());
    }

    @Test
    public void testOfDienstVerdubbellbaarIs(){
        assertTrue(dienst.getVerdubbelbaar());
    }

    @Test
    public void testOfDienstAanbiederToont(){
        assertEquals(aanbieder, dienst.getAanbieder());
    }

    @Test
    public void testOfDienstPrijsPerMaandToont(){
        assertEquals(prijsPerMaand, dienst.getPrijsPerMaand(), DOUBLEDELTA);
    }

}
