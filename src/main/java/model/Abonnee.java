package model;

public class Abonnee {

    private int idAbonnee;
    private String naam;
    private String email;



    public Abonnee(int idAbonnee, String naam, String email){

        this.idAbonnee = idAbonnee;
        this.naam = naam;
        this.email = email;


    }


    public int getIdAbonnee() {
        return idAbonnee;
    }

    public void setIdAbonnee(int idAbonnee) {
        this.idAbonnee = idAbonnee;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
