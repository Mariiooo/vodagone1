package responses;

import model.Abonnement;

public class AbonnementenOverzichtGespecificeerd {


    private int idAbonnement;
    private String aanbiederNaam;
    private String dienstNaam;
    private String prijs;
    private String startdatum;
    private int verdubbeld;
    private boolean deelbaarAbo;
    private String abonnementStatus;

    public AbonnementenOverzichtGespecificeerd(Abonnement abonnement) {
        this.idAbonnement = abonnement.getIdAbonnement();
        this.aanbiederNaam = abonnement.getAanbieders();
        this.dienstNaam = abonnement.getNaam();
        this.prijs = abonnement.prijsAlsString();
        this.startdatum = abonnement.getStartdatum();
        this.verdubbeld = abonnement.getVerdubbeld();
        this.deelbaarAbo = abonnement.isDeelbaarAbo();
        this.abonnementStatus = abonnement.getabonnementStatus();

    }


}
