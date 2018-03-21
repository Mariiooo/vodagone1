package model;

import java.util.ArrayList;

public class Abonnementen {


    public ArrayList<Abonnement> abonnementen = new ArrayList<>();

    private double totalPrice;

    public void addAbonnement(Abonnement abonnoment) {
        abonnementen.add(abonnoment);
        totalPrice = 10;
    }





}
