package responses;

import model.Abonnement;

import java.util.ArrayList;

public class AbonnementenResponse {

    private ArrayList<AbonnementOverzichtResponse> abonnementenOverzicht;
    private double totaalprijs;

    public AbonnementenResponse(ArrayList<Abonnement> abonnementen){
        this.abonnementenOverzicht = new ArrayList<>();
        this.totaalprijs = 0.00;

        for(Abonnement abonnementLijst: abonnementen){
            if( abonnementLijst.isAbonnementEigenaar())
                    this.totaalprijs += abonnementLijst.getPrijs();
            this.abonnementenOverzicht.add(new AbonnementOverzichtResponse(abonnementLijst));
        }


    }


}