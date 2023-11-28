package activeRecord;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.* ;

public class TestPersonne {

    @BeforeEach
    public void init() throws SQLException {
        Personne.createTable();
        Personne p1 = new Personne("Becker" , "Doryann");
        Personne p2 = new Personne("Ottelard" , "Kyliane");
        Personne p3 = new Personne("Deuf" , "John");
        Personne p4 = new Personne("Becker" , "Jayson");
        p1.save();
        p2.save();
        p3.save();
        p4.save();
    }

    @AfterEach
    public void end() throws SQLException {
        Personne.deleteTable();
    }

    @Test
    public void testFindAll() throws SQLException {
        ArrayList<Personne> list = Personne.findAll();
        assertEquals(list.size() , 3);
    }

    @Test
    public void testFindById() throws SQLException {
        Personne p = Personne.findById(1);
        assertEquals("Becker", p.getNom());
        Personne p2 = Personne.findById(10);
        assertNull(p2);
    }

    @Test
    public void testFindByName() throws SQLException {
        ArrayList<Personne> list = Personne.findByName("Ottelard");
        assertEquals(list.size() , 1);
        list = Personne.findByName("Becker");
        assertEquals(list.size() , 2);
        list = Personne.findByName("Pierre");
        assertTrue(list.isEmpty());
    }

}
