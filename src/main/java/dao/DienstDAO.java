package dao;

import model.Dienst;

import java.sql.SQLException;
import java.util.ArrayList;

public class DienstDAO extends MainDAO {


    private static final String alleDienstenOverzicht = "SELECT dienst.IDDIENST, dienst.AANBIEDERNAAM, dienst.NAAM, " +
            "(SELECT prijzen.PRIJS FROM prijzen prijzen WHERE prijzen.IDDIENST = dienst.IDDIENST AND prijzen.ABONNEMENTENDUUR " +
            "= 'maand' )MaandelijkseKosten, dienst.DEELBAAR, dienst.AANBIEDERNAAM FROM dienst dienst";


    public ArrayList<Dienst> alleDiensten() {

        super.selectQuery(String.format(alleDienstenOverzicht));
        ArrayList<Dienst> dienstArrayList = new ArrayList<>();

        try {
            super.executeQuery();

            while (super.resultSet.next()) {

                Dienst dienst = maakNewDienst();
                dienstArrayList.add(dienst);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }

        return dienstArrayList;
    }


    protected Dienst maakNewDienst() throws SQLException {

        int idDienst = super.resultSet.getInt("idDienst");
        String naam = super.resultSet.getString("naam");
        int deelbaar = super.resultSet.getInt("deelbaar");
        boolean verdubbelbaar = super.resultSet.getBoolean("verdubbelbaar");
        String aanbiederNaam = super.resultSet.getString("aanbiederNaam");
        double prijsVanAbonnement = super.resultSet.getDouble("prijsVanAbonnement");

        return new Dienst(idDienst, naam, deelbaar, verdubbelbaar, aanbiederNaam, prijsVanAbonnement);
    }


}

