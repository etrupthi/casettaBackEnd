package dao;

import models.Hotel;


public interface HotelDao extends CrudDao<Hotel, Integer> {

}



/*
package dao;

import com.google.inject.Inject;
import models.Hotel;
import play.db.jpa.JPAApi;

import java.util.Collection;

public interface HotelDao extends CrudDao<Hotel, Integer>{
    Collection<Hotel> createHotel(Collection<Hotel> foodItems);

}*/