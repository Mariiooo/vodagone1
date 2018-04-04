package responses;

import model.Abonnement;

public class AbonnementenOverzichtGespecificeerd {


    private int id;
    private String aanbieder;
    private String dienst;
    private String prijs;
    private String startDatum;
    private String verdubbeling;
    private boolean deelbaar;
    private String status;

    public AbonnementenOverzichtGespecificeerd(Abonnement abonnement) {
        this.id = abonnement.getId();
        this.aanbieder = abonnement.getAanbieders();
        this.dienst = abonnement.getNaam();
        this.prijs = abonnement.prijsAlsString();
        this.startDatum = abonnement.getStartDatum();
        this.verdubbeling = abonnement.getVerdubbeling();
        this.deelbaar = abonnement.isDeelbaarAbo();
        this.status = abonnement.getStatus();

    }


}
