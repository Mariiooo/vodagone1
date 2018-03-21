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


    public void addAbonnementSpecs(int id, String aanbieder, String dienst, String prijs, String startDatum, String verdubbeling, boolean deelbaar, String status) {
       this.id = id;
       this.aanbieder = aanbieder;
       this.dienst = dienst;
       this.prijs = prijs;
       this.startDatum = startDatum;
       this.verdubbeling = verdubbeling;
       this.deelbaar = deelbaar;
       this.status = status;
    }







}
