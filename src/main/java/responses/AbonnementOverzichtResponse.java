package responses;

import model.Abonnement;

public class AbonnementOverzichtResponse {

    private int id;
    private String aanbieder;
    private String dienst;


    public AbonnementOverzichtResponse(Abonnement abonnement){
        this.id = abonnement.getIdAbonnement();
        this.aanbieder = abonnement.getAanbieders();
        this.dienst = abonnement.getNaam();

    }
}
