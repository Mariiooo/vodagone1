package responses;

public class DienstenOverzichtResponse {

    private int id;
    private String aanbieder;
    private String dienst;

    public DienstenOverzichtResponse(int idDienst, String aanbiedernNaam, String dienstNaam){

        this.id = idDienst;
        this.aanbieder = aanbiedernNaam;
        this.dienst = dienstNaam;
    }

    public int getId()
    {
        return this.id;
    }


}
