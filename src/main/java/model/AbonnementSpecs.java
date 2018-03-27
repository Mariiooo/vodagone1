package model;

import java.util.ArrayList;

public class AbonnementSpecs {

    private int id;
    private String aanbieder;
    private String dienst;
    private String prijs;
    private String startDatum;      //The field startDatum should be a date and formatted as yyyy-MM-dd.
    private String verdubbeling;     //The field verdubbeling should be a string and only contain either "standaard", "verdubbeld", "niet-beschikbaar".
    private boolean deelbaar;
    private String status;          //The field status should be a string and only contain either "opgezegd", "actief" or "proef".


    public AbonnementSpecs(int id, String aanbieder, String dienst, String prijs, String startDatum, String verdubbeling, boolean deelbaar, String status) {
       this.id = id;
       this.aanbieder = aanbieder;
       this.dienst = dienst;
       this.prijs = prijs;
       this.startDatum = startDatum;
       this.verdubbeling = verdubbeling;
       this.deelbaar = deelbaar;
       this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAanbieder() {
        return aanbieder;
    }

    public void setAanbieder(String aanbieder) {
        this.aanbieder = aanbieder;
    }

    public String getDienst() {
        return dienst;
    }

    public void setDienst(String dienst) {
        this.dienst = dienst;
    }

    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }

    public String getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(String startDatum) {
        this.startDatum = startDatum;
    }

    public String getVerdubbeling() {
        return verdubbeling;
    }

    public void setVerdubbeling(String verdubbeling) {
        this.verdubbeling = verdubbeling;
    }

    public boolean isDeelbaar() {
        return deelbaar;
    }

    public void setDeelbaar(boolean deelbaar) {
        this.deelbaar = deelbaar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
