package dao;


public class TokenDAO extends MainDAO {

    private static final String INSERT_NEW_TOKEN_OR_UPDATE_TOKEN_QUERY = "INSERT INTO token VALUES('%1$s', %2$d, CURDATE() + INTERVAL 5 DAY) " +
            "on duplicate key UPDATE token = '%1$s', `VERLOOPDATUM` = CURDATE() + INTERVAL 10 DAY";

    private static final String DELETE_TOKEN_QUERY = "DELETE FROM token WHERE `VERLOOPDATUM` < CURDATE() - INTERVAL 1 DAY";

    public TokenDAO() {
        super();
    }

    public void updateOrInsertUserToken(String token, int idabonnee) {
        super.selectQuery(String.format(INSERT_NEW_TOKEN_OR_UPDATE_TOKEN_QUERY, token, idabonnee));
        super.executeUpdate();
    }

    public void deleteUserToken() {
        super.selectQuery(DELETE_TOKEN_QUERY);
        super.executeUpdate();
    }
}
