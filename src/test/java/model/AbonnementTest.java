package model;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbonnementTest {

    private Abonnement normaalAbonnement;
    private Abonnement verdubbeldAbonnement;
    private Abonnement nietDeelbaarAbonnement;
    private Abonnement opgezegdAbonnement;
    private Abonnement gedeeldeAbonnement;
    private Dienst normaalDienst;
    private Dienst verdubbeldDienst;
    private Dienst deelbaarDienst;
    private Dienst nietDeelbaarDienst;
    private final double DOUBLEDELTA = 0.001;


    @Before
    public void init() {
        this.normaalDienst = new Dienst(1, "HBO 1,2,3 + CanalPlus", 1, false, "ziggo", 29.99);
        this.verdubbeldDienst = new Dienst(2, "CanalPlus Verdubbeld veel Zenders", 1, true, "vodafone", 15.00);
        this.deelbaarDienst = new Dienst(3, "Eurosport with Friends", 1, false, "ziggo", 5.00);
        this.nietDeelbaarDienst = new Dienst(4, "Singel Movie Abo", 0, true, "vodafone", 10.00);

        this.normaalAbonnement = new Abonnement(1, "actief", "2018-04-01", true, normaalDienst, false);
        this.verdubbeldAbonnement = new Abonnement(2, "proef", "2018-04-01", true, verdubbeldDienst, true);
        this.nietDeelbaarAbonnement = new Abonnement(3, "actief", "2018-01-01", true, nietDeelbaarDienst, false);
        this.opgezegdAbonnement = new Abonnement(4, "opgezegd", "2018-03-01", true, deelbaarDienst, true);
        this.gedeeldeAbonnement = new Abonnement(5, "actief", "2018-02-01", false, normaalDienst, false);
    }

    @Test
    public void normaalAbonnementToontId() {
        assertEquals(1, normaalAbonnement.getId());
    }

    @Test
    public void normaalAbonnementToontDienst() {
        assertEquals("HBO 1,2,3 + CanalPlus", normaalAbonnement.getNaam());
    }

    @Test
    public void normaalAbonnementisDeelbaar() {
        assertTrue(normaalAbonnement.isDeelbaarAbo());
    }

    @Test
    public void normaalAbonnementIsNietVerdubbelbaar() {
        assertEquals("niet-beschikbaar", normaalAbonnement.getVerdubbeling());
    }

    @Test
    public void normaalAbonnementHeeftJuisteAanbieder() {
        assertEquals("ziggo", normaalAbonnement.getAanbieders());
    }

    @Test
    public void normaalAbonnementHeeftPrijs() {
        assertEquals(29.99, normaalAbonnement.getPrijs(), DOUBLEDELTA);
    }

    @Test
    public void verdubbeldAbonnementStatusIsProef() {
        assertEquals("proef", verdubbeldAbonnement.getStatus());
    }

    @Test
    public void verdubbeldAbonnementDatumCorrect() {
        assertEquals("2018-04-01", verdubbeldAbonnement.getStartDatum());
    }

    @Test
    public void verdubbeldAbonnementAbonneeIsEigenaar() {
        assertTrue(verdubbeldAbonnement.isAbonnementEigenaar());
    }

    @Test
    public void abonnementToontStandaardBijVerdubbelling() {
        assertEquals("standaard", nietDeelbaarAbonnement.getVerdubbeling() );
    }

    @Test
    public void verdubbeldAbonnementToontVerdubbeldBijVerdubbelling() {
        assertEquals("verdubbeld", verdubbeldAbonnement.getVerdubbeling());

    }

    @Test
    public void opgezegdAbonnementZouGeenPrijsMoetenHebben() {
        assertEquals(0.0, opgezegdAbonnement.getPrijs(), DOUBLEDELTA);
    }

    @Test
    public void opgezegdAbonnementZouMoetenZijnOpgezegd() {
        assertEquals("opgezegd", opgezegdAbonnement.getStatus());

    }

    @Test
    public void kijkOfIkEigenaarBen() {
        assertEquals(true, opgezegdAbonnement.isAbonnementEigenaar());
    }

    @Test
    public void toonPrijsAlsString() {
        assertEquals("€10.00 per maand", nietDeelbaarAbonnement.prijsAlsString());
    }

    @Test
    public void nietEigenaarVanGedeeldAbonnement(){
        assertFalse(gedeeldeAbonnement.isAbonnementEigenaar());
    }





}
