
import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://ec2-174-129-231-25.compute-1.amazonaws.com:5432/d8vi119m4qfk34", "akdscbrcazssbr", "2c1c9fca8d1bdf7e85d3a6ac1a59990cdec49be1b0ca6c638bd32b6f1d53363f");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animal *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
        }
    }

}