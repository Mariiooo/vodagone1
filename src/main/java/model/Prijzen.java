package model;

public class Prijzen {

    private Dienst idDienst;
    private double prijs;
    private Abonnementenduur abonnementenduur;
    private double verdubbelingAbonnement = 1.5;

    public Prijzen(Dienst idDienst, double prijs, Abonnementenduur abonnementenduur){
        this.idDienst = idDienst;
        this.prijs = prijs;
        this.abonnementenduur = abonnementenduur;
    }


    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public double getVerdubbelingAbonnement() {
        return verdubbelingAbonnement;
    }

    public void setVerdubbelingAbonnement(double verdubbelingAbonnement) {
        this.verdubbelingAbonnement = verdubbelingAbonnement;
    }
}
