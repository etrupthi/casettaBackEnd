package dao;

import models.Hotel;
import play.db.jpa.JPAApi;
import play.libs.F;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class HotelDaoImpl implements HotelDao {

    final JPAApi jpaApi;

    @Inject
    public HotelDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public Hotel create(Hotel hotel) {

        if (null == hotel) {
            throw new IllegalArgumentException("Book must be provided");
        }

        jpaApi.em().persist(hotel);
        return hotel;
    }

    public Optional<Hotel> read(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("Id must be provided");
        }

        final Hotel hotel = jpaApi.em().find(Hotel.class, id);
        return hotel != null ? Optional.of(hotel) : Optional.empty();

    }

    public Hotel update(Hotel hotel) {

        if (null == hotel) {
            throw new IllegalArgumentException("Book must be provided");
        }

        if (null == hotel.getId()) {
            throw new IllegalArgumentException("Book id must be provided");
        }

        final Hotel existingHotel = jpaApi.em().find(Hotel.class, hotel.getId());
        if (null == existingHotel) {
            return null;
        }

        existingHotel.setName(hotel.getName());

        jpaApi.em().persist(existingHotel);

        return existingHotel;
    }

    public Hotel delete(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("Book id must be provided");
        }

        final Hotel existingHotel = jpaApi.em().find(Hotel.class, id);
        if (null == existingHotel) {
            return null;
        }

        jpaApi.em().remove(existingHotel);

        return existingHotel;
    }

    public Collection<Hotel> all() {

        TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b", Hotel.class);
        List<Hotel> hotels = query.getResultList();

        return hotels;
    }

}
