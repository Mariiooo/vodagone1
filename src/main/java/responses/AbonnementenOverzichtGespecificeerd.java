package responses;

import model.Abonnement;

public class AbonnementenOverzichtGespecificeerd {


    private int id;
    private String aanbieder;
    private String dienst;
    private String prijs;
    private String startDatum;
    private int verdubbeling;
    private boolean deelbaar;
    private String status;

    public AbonnementenOverzichtGespecificeerd(Abonnement abonnement) {
        this.id = abonnement.getIdAbonnement();
        this.aanbieder = abonnement.getAanbieders();
        this.dienst = abonnement.getNaam();
        this.prijs = abonnement.prijsAlsString();
        this.startDatum = abonnement.getStartdatum();
        this.verdubbeling = abonnement.getVerdubbeld();
        this.deelbaar = abonnement.isDeelbaarAbo();
        this.status = abonnement.getabonnementStatus();

    }


}
