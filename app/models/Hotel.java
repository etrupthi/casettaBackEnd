package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Basic
    @JsonProperty("name")
    private String name;

    @Basic
    @JsonProperty("location")
    private String location;

    @Basic
    @JsonProperty("price")
    private Integer price;

    @Basic
    @JsonProperty("rating")
    private String rating;

    @Basic
    @JsonProperty("description")
    private String description;

    @Basic
    @JsonProperty("url")
    private String url;

    public Hotel(Integer id, String name, String location, Integer price,String rating,String description, String url)
    {
        this.id=id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.rating = rating;
        this.description=description;
        this.url=url;

    }

    public Hotel() {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

