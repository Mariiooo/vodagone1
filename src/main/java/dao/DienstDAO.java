package dao;

import model.Dienst;

import java.sql.ResultSet;
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

                Dienst dienst = maakNewDienst(super.resultSet);
                dienstArrayList.add(dienst);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }

        return dienstArrayList;
    }


    protected Dienst maakNewDienst(ResultSet resultSet) throws SQLException {

        int idDienst = resultSet.getInt("IDDIENST");
        String naam = resultSet.getString("naam");
        int deelbaar = resultSet.getInt("AboGedeeld");
        boolean verdubbelbaar = resultSet.getBoolean("verdubbelbaar");
        String aanbiederNaam = resultSet.getString("aanbiederNaam");
        double prijsVanAbonnement = resultSet.getDouble("MaandelijksePrijs");

        return new Dienst(idDienst, naam, deelbaar, verdubbelbaar, aanbiederNaam, prijsVanAbonnement);
    }


}

