package responses;

public class DienstenOverzichtResponse {

    private int id;
    private String aanbieder;
    private String dienst;


    public DienstenOverzichtResponse(){

    }

    public DienstenOverzichtResponse(int id, String aanbieder, String dienst)
    {
        this.id = id;
        this.aanbieder = aanbieder;
        this.dienst = dienst;
    }

    public int getId()
    {
        return this.id;
    }
}
