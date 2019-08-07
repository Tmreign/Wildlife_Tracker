import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void monster_instantiatesCorrectly_true() {
        Sighting testSighting = new Sighting("isaac", "Zone A", "1", "1","A");
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void Monster_instantiatesWithrangerName_String() {
        Sighting testSighting = new Sighting("isaac", "Zone A", "1", "1","B");
        assertEquals("isaac", testSighting.getrangername());
    }

    @Test
    public void Monster_instantiatesWithLocation_String() {
        Sighting testSighting = new Sighting("isaac", "Zone A", "1", "1","C");
        assertEquals("C", testSighting.getlocation());
    }


}