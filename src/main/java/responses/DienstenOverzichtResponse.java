package responses;

public class DienstenOverzichtResponse {

    private int idDienst;
    private String aanbiedernNaam;
    private String dienstNaam;

    public DienstenOverzichtResponse(int idDienst, String aanbiedernNaam, String dienstNaam){

        this.idDienst = idDienst;
        this.aanbiedernNaam = aanbiedernNaam;
        this.dienstNaam = dienstNaam;
    }

    public int getIdDienst()
    {
        return this.idDienst;
    }


}
