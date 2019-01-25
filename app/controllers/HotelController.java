package controllers;


import com.fasterxml.jackson.databind.JsonNode;

import models.Hotel;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Results.ok;

public class HotelController {

    public Result getHotel() {

        List<Hotel> hotels = new ArrayList<>();

        // Adding new elements to the ArrayList
        hotels.add(new Hotel(1,"Peerless Inn","Hyderabad",5000));
        hotels.add(new Hotel(2,"Taj","Hyderabad",6000));
        hotels.add(new Hotel(3,"ITC Kakathiya","Hyderabad",10000));

        final JsonNode result = Json.toJson(hotels);
        return ok(result);


    }
}
