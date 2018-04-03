package dao;


import model.Abonnee;
import model.LoginAndToken;
import model.Token;

import javax.inject.Inject;
import java.sql.SQLException;


public class UserDAO extends MainDAO {

    @Inject
    TokenDAO tokenDAO;
    AbonnementenDAO abonnementenDAO;


    private static final String SelectUserquery = "SELECT IDABONNEE, NAAM, EMAIL,( SELECT token.TOKEN FROM token token WHERE token.IDABONEE = abonnee.IDABONNEE) AS token FROM abonnee abonnee WHERE IDABONNEE = ( SELECT IDABONEE FROM gebruiker WHERE GEBRUIKERSNAAM = '%1$s' AND WACHTWOORD = '%2$s') ";

    public UserDAO() {
        super();
    }


    public LoginAndToken getNewUser(String gebruikersnaam, String wachtwoord) {

       // tokenDAO.deleteUserToken();  //  Werkt nog niet helemaal.. morgen aan denis vragen waarom die nullpointer krijgt.
      //  abonnementenDAO.updateAbonnementenVanGebruiker(); //  Werkt nog niet helemaal.. morgen aan denis vragen waarom die nullpointer krijgt.


        super.selectQuery(String.format(SelectUserquery, gebruikersnaam, wachtwoord));
        LoginAndToken loginAndToken = null;

        try {
            super.executeQuery();

            while (super.resultSet.next()) {

                Abonnee abonnee = maakNewAbonnee();
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


    private Abonnee maakNewAbonnee() throws SQLException {

        int idAbonnee = resultSet.getInt("idAbonnee");
        String naam = resultSet.getString("naam");
        String email = resultSet.getString("email");
        return new Abonnee(idAbonnee, naam, email);

    }


}
