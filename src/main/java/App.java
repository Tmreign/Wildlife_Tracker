import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

//        String layout = "layout.hbs";

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("track", req.session().attribute("track"));
            return new ModelAndView(model, "index.hbs");

        },new HandlebarsTemplateEngine());


        get("/endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("track", request.session().attribute("track"));
            return new ModelAndView(model, "endangered.hbs");
        },new HandlebarsTemplateEngine());


        get("/animaldisplay", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("tracks", Animal.all());
            return new ModelAndView(model, "animaldisplay.hbs");

        },new  HandlebarsTemplateEngine());

        get("/endangereddisplay", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("tracks", Sighting.all());

            return new ModelAndView(model, "endangereddisplay.hbs");

        },new HandlebarsTemplateEngine());


        get("/animal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("tracks", request.session().attribute("track"));
            return new ModelAndView(model, "animal.hbs");

        }, new HandlebarsTemplateEngine());


        //post//

        post("/animaldisplay", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String rangername = request.queryParams("rangername");
            String animalname = request.queryParams("animalname");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");

            Animal newAnimal = new Animal(rangername, animalname, health, age, location);
            newAnimal.save();
           return  new ModelAndView(model, "animaldisplay.hbs");

        }, new  HandlebarsTemplateEngine());

        post("/endangereddisplay", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String rangername = request.queryParams("rname");
            String animalname = request.queryParams("aname");
            String health = request.queryParams("ahealth");
            String age = request.queryParams("aage");
            String location = request.queryParams("alocation");

            Sighting newSighting = new Sighting (rangername, animalname, health, age, location);
            newSighting.save();
            return  new ModelAndView(model, "endangereddisplay.hbs");

        },new HandlebarsTemplateEngine());

        post("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String rangername = request.queryParams("rangername");
            String animalname = request.queryParams("animalname");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");

            Animal newAnimal = new Animal(rangername, animalname, health, age, location);
            newAnimal.save();
            return  new ModelAndView(model, "success.hbs");

        },new HandlebarsTemplateEngine());

        post("/esuccess", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String rangername = request.queryParams("rname");
            String animalname = request.queryParams("aname");
            String health = request.queryParams("ahealth");
            String age = request.queryParams("aage");
            String location = request.queryParams("alocation");

            Sighting newSighting = new Sighting (rangername, animalname, health, age, location);
            newSighting.save();

            return  new ModelAndView(model, "esuccess.hbs");


        },new HandlebarsTemplateEngine());


    }
}
