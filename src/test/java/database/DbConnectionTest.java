//package database;
//
//
//import java.sql.Connection;
//import java.sql.Statement;
//
//import dao.MainDAO;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//
//public class DbConnectionTest {
//
//    @InjectMocks private DbConnection dbConnection
//    @InjectMocks private MainDAO mainDAO;
//    @Mock private Connection mockConnection;
//    @Mock private Statement mockStatement;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testMockDBConnection() throws Exception {
//        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
//        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
//        int value = mainDAO.executeQuery("");
//        Assert.assertEquals(value, 1);
//        Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
//    }
//
//}