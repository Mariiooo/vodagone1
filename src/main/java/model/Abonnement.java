package model;

public class Abonnement {

    public static final String VERDUBBELD = "verdubbeld";
    public static final String STANDAARD = "standaard";
    public static final String NIET_BESCHIKBAAR = "niet-beschikbaar";
    public static final String € = "€";
    public static final String PER_MAAND = "0 per maand";
    public static final String OPGEZEGD = "opgezegd";
    public static final double ZERO_ZERO = 0.00;

    private int id;
    private String status;
    private String verdubbeling;
    private String startDatum;
    private Dienst dienst;
    private double abonnementVerdubbelling = 1.5;
    private boolean abonnementEigenaar;


    public Abonnement(int id, String status, String startDatum, boolean abonnementEigenaar, Dienst dienst, boolean verdubbeld) {
        this.id = id;
        this.status = status;
        if (dienst.getVerdubbelbaar()) {
            if (verdubbeld) {
                this.verdubbeling = VERDUBBELD;
            } else {
                this.verdubbeling = STANDAARD;
            }
        } else {
            this.verdubbeling = NIET_BESCHIKBAAR;
        }
        this.startDatum = startDatum;
        this.abonnementEigenaar = abonnementEigenaar;
        this.dienst = dienst;

    }


    public int getId() {
        return this.id;
    }

    public String getNaam() {
        return dienst.getDienst();
    }

    public String getAanbieders() {
        return dienst.getAanbieder();
    }


    public boolean isAbonnementEigenaar() {
        return this.abonnementEigenaar;
    }

    public String prijsAlsString() {
        double prijs = this.getPrijs();
        return € + prijs + PER_MAAND;
    }

    public boolean isDeelbaarAbo() {

        return this.abonnementEigenaar && dienst.getDeelbaar() > 0;
    }

    public double getPrijs() {

        double prijs = ZERO_ZERO;
        if (!this.status.equals(OPGEZEGD)) {

            switch (verdubbeling){
                case VERDUBBELD:
                prijs += dienst.getPrijsPerMaand() * abonnementVerdubbelling;
                break;
            default:
                prijs += dienst.getPrijsPerMaand();
                break;
            }
        }
        return prijs;
    }

    public String getStatus() {
        return status;
    }

    public String getVerdubbeling() {
        return this.verdubbeling;
    }

    public String getStartDatum() {
        return this.startDatum;
    }

}
