package activeRecord;

import java.sql.SQLException;
import java.util.ArrayList;

public class main {
    public static void main (String [] args) throws SQLException {
        Personne p = Personne.findById(4);
        System.out.println(p.toString());
    }
}
