package activeRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnexion {

    private static DBconnexion connexion ;
    private static Connection connection;
    String userName = "root";
    String password = "";
    String serverName = "localhost";
    //Attention, sous MAMP, le port est 8889
    String portNumber = "3306";

    // iL faut une base nommee testPersonne !
    String dbName = "testpersonne";

    private DBconnexion() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);
        String urlDB = "jdbc:mysql://" + serverName + ":";
        urlDB += portNumber + "/" + dbName;
        connection = DriverManager.getConnection(urlDB, connectionProps);
    }

    public static synchronized Connection getConnexion() throws SQLException {
        if (connexion == null) {
            connexion = new DBconnexion();
        }
        return connection;
    }

    public void setNomDB(String nom){
        if (!this.dbName.equals(nom)){
            this.dbName = nom ;
            connection = null;
            connexion = null;
        }
    }
}
