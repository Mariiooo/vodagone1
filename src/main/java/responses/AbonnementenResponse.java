package responses;

import model.Abonnement;

import java.util.ArrayList;

public class AbonnementenResponse {

    private ArrayList<AbonnementOverzichtResponse> abonnementen;
    private double totalPrice;

    public AbonnementenResponse(ArrayList<Abonnement> abonnementen) {
        this.abonnementen = new ArrayList<>();
        this.totalPrice = 0.00;

        for (Abonnement abonnement : abonnementen) {
            if (abonnement.isAbonnementEigenaar()) {
                this.totalPrice += abonnement.getPrijs();
            }
            this.abonnementen.add(new AbonnementOverzichtResponse(abonnement));
        }
    }
}