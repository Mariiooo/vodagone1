package dao;

import model.Abonnement;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;

public class AbonnementenDAO extends MainDAO {

    private static final String alleAbonnementenOverzicht = "SELECT abonnement.IDABONNEMENT, abonnement.VERDUBBELD, abonnement.STARTDATUM, " +
            "abonnement.ABONNEMENTSTATUS, abonnement.EINDDATUM, ( SELECT abonnement.IDABONNEE =( " +
            "SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '1234-1234-1234' ) ) AS" +
            " AbonnementEigenaar, dienst.NAAM, dienst.IDDIENST, dienst.AANBIEDERNAAM, ( " +
            "SELECT prijzen.PRIJS FROM prijzen prijzen WHERE prijzen.IDDIENST = dienst.IDDIENST AND " +
            "prijzen.ABONNEMENTENDUUR = 'maand' ) MaandelijksePrijs, ( SELECT dienst.DEELBAAR -( SELECT COUNT(*) " +
            "FROM DEELABO DEELABO WHERE DEELABO.IDABONNEMENT = abonnement.IDABONNEMENT ) ) AS AboGedeeld, " +
            "dienst.VERDUBBELBAAR FROM abonnement abonnement INNER JOIN dienst dienst ON " +
            "abonnement.IDDIENST = dienst.IDDIENST WHERE abonnement.IDABONNEE =( SELECT token.IDABONEE " +
            "FROM token token WHERE token.TOKEN = '1234-1234-1234' ) OR abonnement.IDABONNEMENT =( " +
            "SELECT deelabo.IDABONNEMENT FROM deelabo deelabo WHERE deelabo.IDABONNEE =( SELECT token.IDABONEE " +
            "FROM token token WHERE token.TOKEN = '1234-1234-1234' ) )";


    private static final String alleAbonnementenPerId = "SELECT, abonnement.IDABONNEMENT, abonnement.VERDUBBELD, abonnement.STARTDATUM, abonnement.EINDDATUM, " +
            "abonnement.ABONNEMENTSTATUS(SELECT abonnement.IDABONNEE =(SELECT token.IDABONEE FROM token token WHERE token.TOKEN ='%1$s')) AS AbonnementEigenaar, " +
            "dienst.NAAM,dienst.IDDIENST AS IdDienst,dienst.AANBIEDERNAAM,(SELECT prijzen.PRIJS FROM prijzen prijzen WHERE prijzen.IDDIENST = dienst.IDDIENST " +
            "AND prijzen.ABONNEMENTENDUUR ='maand')MaandelijksePrijs,(SELECT dienst.DEELBAAR -(SELECT COUNT(*) FROM DEELABO DEELABO WHERE " +
            "DEELABO.IDABONNEMENT =abonnement.IDABONNEMENT))AS AboGedeeld,dienst.VERDUBBELBAAR FROM abonnement abonnement INNER JOIN dienst dienst " +
            "ON abonnement.IDDIENST = dienst.IDDIENST WHERE abonnement.IDABONNEE %2$d AND(abonnement.IDABONNEE =( SELECT token.IDABONEE FROM token token " +
            "WHERE token.TOKEN='%1$s') OR abonnement.IDABONNEMENT IN(SELECT abonnement.IDABONNEE FROM abonnement abonnement2 WHERE abonnement2.IDABONNEMENT IN(" +
            "SELECT deelabo.IDABONNEMENT FROM deelabo deelabo WHERE deelabo.IDABONNEE=(SELECT token.IDABONEE FROM token token WHERE token.TOKEN='%1$s'))))";

    private static final String toevoegenAbonnementen = "INSERT INTO `abonnement`(`IDABONNEE`, `IDDIENST`, `ABONNEMENTENDUUR`, " +
            "`ABONNEMENTSTATUS`, `VERDUBBELD`, `STARTDATUM`, `EINDDATUM`) VALUES (SELECT token.IDABONEE FROM token token " +
            "WHERE token.TOKEN = '%1$s'), %2$d, 'maand', 'proef', false, CURDATE(), NULL) ";

    private static final String updateAbonnementenProefTotActiefQuery = " UPDATE `abonnement` SET `ABONNEMENTSTATUS`= 'actief' " +
            "WHERE `ABONNEMENTSTATUS` = 'proef' AND DATEDIFF(CURDATE(), `STARTDATUM`) > 30";

    private static final String updateAbonnementenActiefTotOpgezegdQuery = " UPDATE `abonnement` SET `ABONNEMENTSTATUS`= 'opgezegd' " +
            "WHERE `ABONNEMENTSTATUS` = 'actief' AND DATEDIFF(CURDATE(), `EINDDATUM`) > 0";

    private static final String abonnementenOpzeggenQuery = " UPDATE `abonnement` SET `ABONNEMENTSTATUS`= 'opgezegd' WHERE " +
            "`IDABONNEMENT` = %2$d AND `IDABONNEE` = (SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '%1$s')";

    private static final String updateAbonnementenVerdubellingQuery = " UPDATE `abonnement` SET `VERDUBBELD`= true WHERE `IDABONNEMENT` = %2$d " +
            "AND `IDABONNEE` = (SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '%1$s')";


    @Inject
    DienstDAO dienstDAO;

    public AbonnementenDAO() {
        super();
    }

    public ArrayList<Abonnement> alleAbonnementen(String token) {

        super.selectQuery(String.format(alleAbonnementenOverzicht, token));
        ArrayList<Abonnement> abonnementArrayList = new ArrayList<>();
        System.out.println("dit zit in de lijst:   " + abonnementArrayList);

        try {

            super.executeQuery();

            while (super.resultSet.next()) {
                Abonnement abonnement = maakNewAbonnement();
                abonnementArrayList.add(abonnement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }
        return abonnementArrayList;
    }


    public Abonnement alleAbonnementenPerId(String token, int id) {

        super.selectQuery(String.format(alleAbonnementenPerId, token, id));
        Abonnement abonnement = null;

        try {

            super.executeQuery();

            while (super.resultSet.next()) {
                System.out.println(resultSet);
                abonnement = maakNewAbonnement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }
        return abonnement;
    }


    public void nieuweAbonnementenToevoegen(String token, int id) {
        super.selectQuery(String.format(toevoegenAbonnementen, token, id));
        super.executeUpdate();
    }


    public void updateAbonnementenProefTotActief() {
        super.selectQuery(String.format(updateAbonnementenProefTotActiefQuery));
        super.executeUpdate();
    }

    public void updateAbonnementenActiefTotOpgezegd() {
        super.selectQuery(String.format(updateAbonnementenActiefTotOpgezegdQuery));
        super.executeUpdate();
    }

    public void abonnementenOpzeggen(int id, String token) {
        super.selectQuery(String.format(abonnementenOpzeggenQuery, id, token));
        super.executeUpdate();
    }

    public void updateAbonnementenVerdubelling(int id, String token) {
        super.selectQuery(String.format(updateAbonnementenVerdubellingQuery, id, token));
        super.executeUpdate();
    }


    public void updateAbonnementenVanGebruiker(){
        this.updateAbonnementenProefTotActief();
        this.updateAbonnementenActiefTotOpgezegd();

    }



    private Abonnement maakNewAbonnement() throws SQLException {

        int idAbonnement = super.resultSet.getInt("idAbonnement");
        String abonnementStatus = super.resultSet.getString("abonnementStatus");
        int verdubbeld = super.resultSet.getInt("verdubbeld");
        String startdatum = super.resultSet.getString("startdatum");
        String einddatum = super.resultSet.getString("einddatum");
        boolean abonnementEigenaar = super.resultSet.getBoolean("abonnementEigenaar");

        return new Abonnement(idAbonnement, abonnementStatus, verdubbeld, startdatum, einddatum, abonnementEigenaar, dienstDAO.maakNewDienst());

    }



}
