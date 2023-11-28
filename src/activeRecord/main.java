package activeRecord;

import java.sql.SQLException;
import java.util.ArrayList;

public class main {
    public static void main (String [] args) throws SQLException {
        ArrayList<Personne> list = Personne.findByName("Pierre");
        System.out.println(list.toString());
        Personne.deleteTable();
    }
}
