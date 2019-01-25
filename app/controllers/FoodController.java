package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Food;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

public class FoodController extends Controller {


    public Result getFood() {

        List<Food> foods = new ArrayList<>();

        // Adding new elements to the ArrayList
        foods.add(new Food("Pecan",795));
        foods.add(new Food("Grapes",67));
        foods.add(new Food("Walnuts", 654));
        foods.add(new Food("Almonds",575));
        foods.add(new Food("Hazelnuts", 628));
        foods.add(new Food("Sunflower Seeds", 573));
        foods.add(new Food("Cranberry Beans", 335));
        foods.add(new Food("Avocado", 160));
        foods.add(new Food("Banana", 89));
        foods.add(new Food("Sweet Potato", 86));
        foods.add(new Food("Apples", 52));
        foods.add(new Food("Papaya", 39));
        foods.add(new Food("Okra", 31));
        foods.add(new Food("Lemons", 28));


        final JsonNode result = Json.toJson(foods);
        return ok(result);


    }
}


