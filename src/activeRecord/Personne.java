package activeRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Personne {
    private int id;
    private String nom , prenom ;

    public Personne(String n , String p){
        nom = n ;
        prenom = p ;
        id = -1 ;
    }

    public static synchronized ArrayList<Personne> findAll() throws SQLException {
        ArrayList<Personne> list = new ArrayList<Personne>();
        DBconnexion.setNomDB("testpersonne");
        Connection connect = DBconnexion.getConnexion();
        String SQLPrep = "SELECT * FROM Personne;";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();
        // s'il y a un resultat
        while (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            int id = rs.getInt("id");
            Personne p = new Personne(nom , prenom);
            list.add(p);
        }
        return list;
    }

    public static synchronized Personne findById(int i) throws SQLException {

        DBconnexion.setNomDB("testpersonne");
        Connection connect = DBconnexion.getConnexion();
        String SQLPrep = "SELECT * FROM Personne WHERE id=?;";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.setInt(1, i);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();
        rs.next();
        Personne p;
        if (rs.getRow()==0){
            p = null ;
        }else {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            int id = rs.getInt("id");
            p = new Personne(nom, prenom);
            p.id = id ;
        }
        return p;
    }

    public static synchronized ArrayList<Personne> findByName(String name) throws SQLException {
        ArrayList<Personne> list = new ArrayList<Personne>();
        DBconnexion.setNomDB("testpersonne");
        Connection connect = DBconnexion.getConnexion();
        String SQLPrep = "SELECT * FROM Personne WHERE nom=?;";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.setString(1, name);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                int id = rs.getInt("id");
                Personne p = new Personne(nom , prenom);
                list.add(p);
            }
        return list;
    }

    public String toString(){
        return id+" "+nom+" "+prenom ;
    }

    public static synchronized void createTable() throws SQLException {
        DBconnexion.setNomDB("testpersonne");
        Connection connect = DBconnexion.getConnexion();
        String SQLPrep = "CREATE TABLE Personne ( " + "ID INTEGER  AUTO_INCREMENT, "
                + "NOM varchar(40) NOT NULL, " + "PRENOM varchar(40) NOT NULL, " + "PRIMARY KEY (ID))";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.execute();
    }

    public static synchronized void deleteTable() throws SQLException {
        DBconnexion.setNomDB("testpersonne");
        Connection connect = DBconnexion.getConnexion();
        String SQLPrep = "DROP TABLE Personne";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.execute();
    }

    public void save() throws SQLException {
        DBconnexion.setNomDB("testpersonne");
        Connection connect = DBconnexion.getConnexion();
        if (this.id == -1 ){
            String SQLPrep = "INSERT INTO Personne (nom, prenom) VALUES (?,?);";
            PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
            prep1.setString(1, this.nom);
            prep1.setString(2, this.prenom);
            prep1.execute();
        }else {
            String SQLPrep = "update Personne set nom=?, prenom=? where id=?;";
            PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
            prep1.setString(1, this.nom);
            prep1.setString(2, this.prenom);
            prep1.setInt(3 , this.id);
            prep1.execute();
        }
    }

    public void delete() throws SQLException {
        DBconnexion.setNomDB("testpersonne");
        Connection connect = DBconnexion.getConnexion();
        String SQLPrep = "DELETE FROM Personne WHERE id=?";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.setInt(1, this.id);
        prep1.execute();
    }

    public String getNom(){
        return this.nom;
    }
}
