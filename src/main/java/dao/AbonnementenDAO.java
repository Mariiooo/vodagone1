package dao;

import model.Abonnement;
import model.Dienst;

import java.sql.SQLException;
import java.util.ArrayList;

public class AbonnementenDAO extends MainDAO {

    private static final String ALLE_ABONNEMENTEN_OVERZICHT_QUERY = "SELECT abonnement.IDABONNEMENT, abonnement.VERDUBBELING, abonnement.STARTDATUM, " +
            "abonnement.ABONNEMENTSTATUS, abonnement.EINDDATUM, ( SELECT abonnement.IDABONNEE =( " +
            "SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '%1$s' ) ) AS" +
            " AbonnementEigenaar, dienst.NAAM, dienst.IDDIENST, dienst.AANBIEDERNAAM, ( " +
            "SELECT prijzen.PRIJS FROM prijzen prijzen WHERE prijzen.IDDIENST = dienst.IDDIENST AND " +
            "prijzen.ABONNEMENTENDUUR = 'maand' ) MaandelijkseKosten, ( SELECT dienst.DEELBAAR -( SELECT COUNT(*) " +
            "FROM DEELABO DEELABO WHERE DEELABO.IDABONNEMENT = abonnement.IDABONNEMENT ) ) AS DEELBAAR, " +
            "dienst.VERDUBBELBAAR FROM abonnement abonnement INNER JOIN dienst dienst ON " +
            "abonnement.IDDIENST = dienst.IDDIENST WHERE abonnement.IDABONNEE =( SELECT token.IDABONEE " +
            "FROM token token WHERE token.TOKEN = '%1$s' ) OR abonnement.IDABONNEMENT =( " +
            "SELECT deelabo.IDABONNEMENT FROM deelabo deelabo WHERE deelabo.IDABONNEE =( SELECT token.IDABONEE " +
            "FROM token token WHERE token.TOKEN = '%1$s' ) )";

    private static final String ALLE_ABONNEMENTEN_PER_ID_QUERY = " SELECT abonnement.IDABONNEMENT, abonnement.STARTDATUM, " +
            "abonnement.VERDUBBELING, abonnement.ABONNEMENTSTATUS, ( SELECT abonnement.IDABONNEE =( SELECT token.IDABONEE " +
            "FROM token token WHERE token.TOKEN = '%2$s' ) ) AS AbonnementEigenaar, dienst.IDDIENST AS IdDienst, " +
            "dienst.AANBIEDERNAAM, dienst.NAAM, ( SELECT prijzen.PRIJS FROM prijzen prijzen WHERE prijzen.IDDIENST = dienst.IDDIENST " +
            "AND prijzen.ABONNEMENTENDUUR = 'maand' ) MaandelijkseKosten, ( SELECT dienst.DEELBAAR -( " +
            "SELECT COUNT(*) FROM DEELABO DEELABO WHERE DEELABO.IDABONNEMENT = abonnement.IDABONNEMENT ) ) AS DEELBAAR, " +
            "dienst.VERDUBBELBAAR FROM abonnement abonnement INNER JOIN dienst dienst ON abonnement.IDDIENST = dienst.IDDIENST " +
            "WHERE abonnement.IDABONNEMENT = %1$d AND( abonnement.IDABONNEE =( SELECT token.IDABONEE FROM token token " +
            "WHERE token.TOKEN = '%2$s' ) OR abonnement.IDABONNEE IN( SELECT abonnement.IDABONNEE FROM abonnement abonnement2 " +
            "WHERE abonnement2.IDABONNEE IN( SELECT deelabo.IDABONNEMENT FROM deelabo deelabo WHERE deelabo.IDABONNEE =( " +
            "SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '%2$s')))) ";

    private static final String TOEVOEGEN_ABONNEMENTEN_QUERY = " INSERT INTO `abonnement`(`IDABONNEE`, `IDDIENST`, `ABONNEMENTENDUUR`," +
            " `ABONNEMENTSTATUS`, `VERDUBBELING`, `STARTDATUM`, `EINDDATUM`) VALUES ((SELECT token.IDABONEE " +
            "FROM token token WHERE token.TOKEN = '%1$s'), %2$d, 'maand', 'proef', false, CURDATE(), NULL) ";

    private static final String UPDATE_ABONNEMENTEN_PROEF_TOT_ACTIEF_QUERY = " UPDATE `abonnement` SET `ABONNEMENTSTATUS`= 'actief' " +
            "WHERE `ABONNEMENTSTATUS` = 'proef' AND DATEDIFF(CURDATE(), `STARTDATUM`) > 30";

    private static final String UPDATE_ABONNEMENTEN_ACTIEF_TOT_OPGEZEGD_QUERY = " UPDATE `abonnement` SET `ABONNEMENTSTATUS`= 'opgezegd' " +
            "WHERE `ABONNEMENTSTATUS` = 'actief' AND DATEDIFF(CURDATE(), `EINDDATUM`) > 0";

    private static final String ABONNEMENTEN_OPZEGGEN_QUERY = " UPDATE `abonnement` SET `ABONNEMENTSTATUS`= 'opgezegd' WHERE" +
            "`IDABONNEMENT` = %1$d AND `IDABONNEE` = (SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '%2$s')";

    private static final String UPDATE_ABONNEMENTEN_VERDUBELLING_QUERY = " UPDATE `abonnement` SET `VERDUBBELING`= true WHERE `IDABONNEMENT` = %1$d " +
            "AND `IDABONNEE` = (SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '%2$s')";


    public AbonnementenDAO() {
        super();
    }

    public ArrayList<Abonnement> alleAbonnementenOverzicht(String token) {

        super.selectQuery(String.format(ALLE_ABONNEMENTEN_OVERZICHT_QUERY, token));
        ArrayList<Abonnement> abonnementArrayList = new ArrayList<>();

        try {
            super.executeQuery();

            while (super.resultSet.next()) {
                Abonnement abonnement = maakNieuweAbonnement();
                abonnementArrayList.add(abonnement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }
        return abonnementArrayList;
    }


    public Abonnement alleAbonnementenPerId(int id, String token) {

        super.selectQuery(String.format(ALLE_ABONNEMENTEN_PER_ID_QUERY, id, token));
        Abonnement abonnement = null;

        try {

            super.executeQuery();

            while (super.resultSet.next()) {
                abonnement = maakNieuweAbonnement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }
        return abonnement;
    }


    public void toevoegenAbonnementen(String token, int id) {
        super.selectQuery(String.format(TOEVOEGEN_ABONNEMENTEN_QUERY, token, id));
        System.out.println((String.format(TOEVOEGEN_ABONNEMENTEN_QUERY, token, id)));
        super.executeUpdate();
    }


    public void updateAbonnementenProefTotActief() {
        super.selectQuery(String.format(UPDATE_ABONNEMENTEN_PROEF_TOT_ACTIEF_QUERY));
        super.executeUpdate();
    }

    public void updateAbonnementenActiefTotOpgezegd() {
        super.selectQuery(String.format(UPDATE_ABONNEMENTEN_ACTIEF_TOT_OPGEZEGD_QUERY));
        super.executeUpdate();
    }

    public void abonnementenOpzeggen(int id, String token) {
        super.selectQuery(String.format(ABONNEMENTEN_OPZEGGEN_QUERY, id, token));
        super.executeUpdate();
    }

    public void updateAbonnementenVerdubelling(int id, String token) {
        super.selectQuery(String.format(UPDATE_ABONNEMENTEN_VERDUBELLING_QUERY, id, token));
        super.executeUpdate();
    }


    public void updateAbonnementenVanGebruiker() {
        this.updateAbonnementenProefTotActief();
        this.updateAbonnementenActiefTotOpgezegd();
    }

    private Abonnement maakNieuweAbonnement() throws SQLException {

        int id = super.resultSet.getInt("idAbonnement");
        String status = super.resultSet.getString("abonnementStatus");
        String startDatum = super.resultSet.getString("startdatum");
        boolean VERDUBBELING = super.resultSet.getBoolean("VERDUBBELING");
        boolean abonnementEigenaar = super.resultSet.getBoolean("abonnementEigenaar");

        return new Abonnement(id, status,startDatum, abonnementEigenaar, maakNieuweDienst(), VERDUBBELING);

    }

    private Dienst maakNieuweDienst() throws SQLException {

        int id = super.resultSet.getInt("IDDIENST");
        String naam = super.resultSet.getString("NAAM");
        int deelbaar = super.resultSet.getInt("DEELBAAR");
        boolean verdubbelbaar = super.resultSet.getBoolean("verdubbelbaar");
        String aanbiederNaam = super.resultSet.getString("AANBIEDERNAAM");
        double prijsVanAbonnement = super.resultSet.getDouble("MaandelijkseKosten");

        return new Dienst(id, naam, deelbaar, verdubbelbaar, aanbiederNaam, prijsVanAbonnement);
    }


}
