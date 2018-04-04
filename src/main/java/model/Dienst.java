package model;

public class Dienst {

    private int id;
    private String dienst;
    private int deelbaar;
    private boolean verdubbelbaar;
    private String aanbieder;
    private double prijsPerMaand;


    public Dienst(int id, String dienst, int deelbaar, boolean verdubbelbaar, String aanbieder, double prijsPerMaand) {

        this.id = id;
        this.dienst = dienst;
        this.deelbaar = deelbaar;
        this.verdubbelbaar = verdubbelbaar;
        this.aanbieder = aanbieder;
        this.prijsPerMaand = prijsPerMaand;

    }

    public int getId() {
        return id;
    }

    public String getDienst() {
        return dienst;
    }

    public int getDeelbaar() {
        return deelbaar;
    }

    public boolean getVerdubbelbaar()
    {
        return verdubbelbaar;
    }

    public String getAanbieder() {
        return aanbieder;
    }

    public double getPrijsPerMaand() {
        return prijsPerMaand;
    }
}
