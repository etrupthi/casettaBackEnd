package models;

public class Hotel {

    private Integer id;
    private String name;
    private String location;
    private Integer price;


    public Hotel() {
    }

    public Hotel(Integer id, String name, String location, Integer price) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

