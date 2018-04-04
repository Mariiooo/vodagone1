package dao;


import model.Abonnee;
import model.LoginAndToken;

import java.sql.SQLException;
import java.util.ArrayList;


public class GebruikerDAO extends MainDAO {

    private static final String SELECT_GEBRUIKER_QUERY = "SELECT IDABONNEE, NAAM, EMAIL,( SELECT token.TOKEN FROM token token " +
            "WHERE token.IDABONEE = abonnee.IDABONNEE) AS token FROM abonnee abonnee " +
            "WHERE IDABONNEE = ( SELECT IDABONEE FROM gebruiker WHERE GEBRUIKERSNAAM = '%1$s' AND WACHTWOORD = '%2$s') ";

    private static final String SELECT_ALLE_ABONNEES_BEHALVE_MIJ_QUERY = "SELECT * FROM abonnee WHERE abonnee.IDABONNEE != ( " +
            "SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '%1$s')";

    private static final String DEEL_ABONNEMENT_MET_IEMAND_ANDERS_QUERY = "INSERT INTO `deelabo`(`IDABONNEMENT`, `IDABONNEE`) " +
            "SELECT abonnement.IDABONNEE, %1$d FROM abonnement abonnement WHERE abonnement.IDABONNEMENT = %2$d " +
            "AND abonnement.IDABONNEE = (SELECT token.IDABONEE FROM token token WHERE token.TOKEN = '%3$s')";




    public GebruikerDAO() {
        super();
    }


    public LoginAndToken maakNieuweGebruiker(String gebruikersnaam, String wachtwoord) {

        new TokenDAO().deleteUserToken();
        new AbonnementenDAO().updateAbonnementenVanGebruiker();


        super.selectQuery(String.format(SELECT_GEBRUIKER_QUERY, gebruikersnaam, wachtwoord));
        LoginAndToken loginAndToken = null;
        System.out.println(String.format(SELECT_GEBRUIKER_QUERY, gebruikersnaam, wachtwoord));



        try {
            super.executeQuery();

            while (super.resultSet.next()) {

                Abonnee abonnee = maakNieuweAbonnee();
                String token = super.resultSet.getString("token");
                loginAndToken = new LoginAndToken(abonnee, token);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }
        return loginAndToken;
    }


    private Abonnee maakNieuweAbonnee() throws SQLException {

        int id = resultSet.getInt("idAbonnee");
        String naam = resultSet.getString("naam");
        String email = resultSet.getString("email");
        return new Abonnee(id, naam, email);
    }


    public ArrayList<Abonnee> toonAlleAbonneesBehalveMij(String token) {

        super.selectQuery(String.format(SELECT_ALLE_ABONNEES_BEHALVE_MIJ_QUERY, token));
        ArrayList<Abonnee> abonnees = new ArrayList<>();
        try {
            super.executeQuery();

            while (super.resultSet.next()) {
                Abonnee abonnee = maakNieuweAbonnee();
                abonnees.add(abonnee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.endAllConnections();
        }
        return abonnees;
    }

    public void deelAbonnementMetIemandAnders(int idAbonnee, int idDeelAbo, String token) {
        super.selectQuery(String.format(DEEL_ABONNEMENT_MET_IEMAND_ANDERS_QUERY, idAbonnee, idDeelAbo, token));
        super.executeUpdate();
    }
}
