package model;

public class Dienst {

    private int idDienst;
    private String naam;
    private int deelbaar;
    private boolean verdubbelbaar;
    private String aanbiederNaam;
    private double prijsVanAbonnement;


    public Dienst(int idDienst, String naam, int deelbaar, boolean verdubbelbaar, String aanbiederNaam, double prijsVanAbonnement) {

        this.idDienst = idDienst;
        this.naam = naam;
        this.deelbaar = deelbaar;
        this.verdubbelbaar = verdubbelbaar;
        this.aanbiederNaam = aanbiederNaam;
        this.prijsVanAbonnement = prijsVanAbonnement;

    }

    public String getAanbiederNaam() {
        return aanbiederNaam;
    }

    public int getIdDienst() {
        return idDienst;
    }

    public void setIdDienst(int idDienst) {
        this.idDienst = idDienst;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getDeelbaar() {
        return deelbaar;
    }

    public void setDeelbaar(int deelbaar) {
        this.deelbaar = deelbaar;
    }

    public boolean isVerdubbelbaar() {
        return verdubbelbaar;
    }

    public void setVerdubbelbaar(boolean verdubbelbaar) {
        this.verdubbelbaar = verdubbelbaar;
    }


    public double getPrijsVanAbonnement() {
        return prijsVanAbonnement;
    }

    public void setPrijsVanAbonnement(double prijsVanAbonnement) {
        this.prijsVanAbonnement = prijsVanAbonnement;
    }
}
