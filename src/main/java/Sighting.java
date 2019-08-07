
import java.util.List;
import org.sql2o.*;
public class Sighting {


    private String Rangername;
    private String Animalname;
    private String Health;
    private String Age;
    private String Location;
    private int id;


    public Sighting(String rangername, String animalname, String health,String age, String location) {

        Rangername=rangername;
        Animalname=animalname;
        Health=health;
        Age=age;
        Location=location;
    }

    public String getrangername() {
        return Rangername;
    }

    public String getanimalname() {
        return Animalname;
    }

    public String gethealth() {
        return Health;
    }

    public String getage() {
        return Age;
    }

    public String getlocation() {
        return Location;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object anotherSighting) {
        if (!(anotherSighting instanceof Animal)) {
            return false;
        } else {
            Sighting newsighting = (Sighting) anotherSighting;
            return this.getrangername().equals(newsighting.getrangername()) &&
                    this.getanimalname() == newsighting.getanimalname() &&
                    this.gethealth() == newsighting.gethealth()&&
                    this.getage() == newsighting.getage() &&
                    this.getlocation() == newsighting.getlocation();



        }
    }

    public static List<Sighting> all() {
        String sql = "SELECT * FROM Sighting";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sighting (Rangername ,Animalname, Health, Age, Location) VALUES (:rangername, :animalname , :health , :age , :location)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("rangername", Rangername)
                    .addParameter("animalname", Animalname)
                    .addParameter("health",Health)
                    .addParameter("age", Age)
                    .addParameter("location",Location)
                    .executeUpdate()
                    .getKey();
        }
    }
}