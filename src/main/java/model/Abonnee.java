package model;

public class Abonnee {

    private int id;
    private String naam;
    private String email;

    public Abonnee(int id, String naam, String email){

        this.id = id;
        this.naam = naam;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public String getNaam() {
        return this.naam;
    }

    public String getEmail() {
        return this.email;
    }
}
