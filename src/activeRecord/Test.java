package activeRecord;

import org.junit.Assert;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.* ;
public class Test {
    @org.junit.jupiter.api.Test
    void testunique() throws SQLException {
        Connection c1 = DBconnexion.getConnexion();
        Connection c2 = DBconnexion.getConnexion();
        assertSame(c1, c2);
    }

    @org.junit.jupiter.api.Test
    void testChangement() throws SQLException {
        Connection c1 = DBconnexion.getConnexion();
        DBconnexion.setNomDB("Touiteur");
        Connection c2 = DBconnexion.getConnexion();
        assertNotSame(c1, c2);
    }
    
}
