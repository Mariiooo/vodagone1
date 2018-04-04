package dao;

import model.Dienst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DienstDAO extends MainDAO {


    private static final String ALLE_DIENSTEN_OVERZICHT_QUERY = "SELECT dienst.IDDIENST, dienst.AANBIEDERNAAM, dienst.VERDUBBELBAAR, " +
            "dienst.NAAM, ( SELECT prijzen.PRIJS FROM prijzen prijzen WHERE prijzen.IDDIENST = dienst.IDDIENST " +
            "AND prijzen.ABONNEMENTENDUUR = 'maand' ) MaandelijkseKosten, dienst.DEELBAAR FROM dienst dienst";


    public ArrayList<Dienst> alleDienstenOverzicht() {

        super.selectQuery(String.format(ALLE_DIENSTEN_OVERZICHT_QUERY));
        ArrayList<Dienst> dienstArrayList = new ArrayList<>();

        try {
            super.executeQuery();

            while (super.resultSet.next()) {

                Dienst dienst = maakNieuweDienst(super.resultSet);
                dienstArrayList.add(dienst);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }
        return dienstArrayList;
    }


    protected Dienst maakNieuweDienst(ResultSet resultSet) throws SQLException {

        int idDienst = resultSet.getInt("IDDIENST");
        String naam = resultSet.getString("NAAM");
        int deelbaar = resultSet.getInt("DEELBAAR");
        boolean verdubbelbaar = resultSet.getBoolean("verdubbelbaar");
        String aanbiederNaam = resultSet.getString("AANBIEDERNAAM");
        double prijsVanAbonnement = resultSet.getDouble("MaandelijkseKosten");

        return new Dienst(idDienst, naam, deelbaar, verdubbelbaar, aanbiederNaam, prijsVanAbonnement);
    }
}

