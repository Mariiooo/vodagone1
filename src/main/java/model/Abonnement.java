package model;

public class Abonnement {

    private int idAbonnement;
    private String abonnementStatus;
    private int verdubbeld;
    private String startdatum;
    private String einddatum;
    private Dienst idDienst;
    private Prijzen prijzen;
    private boolean abonnementEigenaar;
    private Dienst dienst;


    public Abonnement(int idAbonnement, String abonnementStatus, int verdubbeld, String startdatum, String einddatum, boolean abonnementEigenaar, Dienst idDienst) {
        this.idAbonnement = idAbonnement;
        this.abonnementStatus = abonnementStatus;
        this.verdubbeld = verdubbeld;
        this.startdatum = startdatum;
        this.einddatum = einddatum;
        this.abonnementEigenaar = abonnementEigenaar;
        this.idDienst = idDienst;

    }


    public int getIdAbonnement() {
        return idAbonnement;
    }

    public String getNaam() {
        return dienst.getNaam();
    }

    public String getAanbieders() {
        return dienst.getAanbiederNaam();
    }

    public boolean isAbonnementEigenaar() {
        return this.abonnementEigenaar;
    }

    public String prijsAlsString(){
        double prijs = this.getPrijs();
        Double doubleInstance = new Double(prijs);
        String numberAsString = doubleInstance.toString();

        return  numberAsString;

    }

    public boolean isDeelbaarAbo(){

        return this.abonnementEigenaar && dienst.getDeelbaar() > 0;

    }

    public void setIdAbonnement(int idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public String getabonnementStatus() {
        return abonnementStatus;
    }


    public int getVerdubbeld() {
        return verdubbeld;
    }

    public void setVerdubbeld(int verdubbeld) {
        this.verdubbeld = verdubbeld;
    }

    public String getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(String startdatum) {
        this.startdatum = startdatum;
    }

    public String getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(String einddatum) {
        this.einddatum = einddatum;
    }

    public Dienst getIdDienst() {
        return idDienst;
    }

    public void setIdDienst(Dienst idDienst) {
        this.idDienst = idDienst;
    }

    public double getPrijs() {

        double prijs = 0.0;
        if (abonnementStatus.equals(verdubbeld)) {
            prijs += idDienst.getPrijsVanAbonnement() * prijzen.getVerdubbelingAbonnement();
        } else {
            prijs += idDienst.getPrijsVanAbonnement();

        }

        return prijs;
    }


}
