package activeRecord;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestPersonne {

    @BeforeEach
    public void init() throws SQLException {
        Personne.createTable();
        Personne p1 = new Personne("Becker" , "Doryann");
        Personne p2 = new Personne("Ottelard" , "Kyliane");
        Personne p3 = new Personne("Deuf" , "John");
        p1.save();
        p2.save();
        p3.save();
    }

    @AfterEach
    public void end() throws SQLException {
        Personne.deleteTable();
    }

    @Test
    public void test1(){

    }

    @Test
    public void test2(){

    }

    @Test
    public void test3(){

    }

}
