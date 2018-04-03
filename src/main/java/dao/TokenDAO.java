package dao;


import java.sql.SQLException;

public class TokenDAO extends MainDAO {

    private static final String UpdateTokenquery =   "insert into token values('%1$s', %2$d, CURDATE() + INTERVAL 5 DAY) " +
            "on duplicate key update token = '%1$s', `VERLOOPDATUM` = CURDATE() + INTERVAL 10 DAY";
    private static final String DeleteTokenquery = "DELETE FROM token WHERE `VERLOOPDATUM` < CURDATE() - INTERVAL 1 DAY";









    public TokenDAO() {
        super();

    }


    public void updateOrInsertUserToken(String token, int idabonnee) throws SQLException {


        super.selectQuery(String.format(UpdateTokenquery, token, idabonnee));
        super.executeUpdate();

    }

    public void deleteUserToken() {

        super.selectQuery(DeleteTokenquery);
        super.executeUpdate();


    }


}
