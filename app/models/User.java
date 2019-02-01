package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class User {


    public enum State {
        PENDING,
        VERIFIED,
        LOCKED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Basic
    @JsonProperty("username")
    private String username;

    @Basic
    @JsonProperty("ownername")
    private String ownername;

    @Basic
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Basic
    @JsonProperty("email")
    private String email;

    @Basic
    @JsonProperty("state")
    private State state;

    @Basic
    @JsonProperty("accessToken")
    private String accessToken;

    public User() {
    }

    public User(Integer id, String username, String password, String email, State state, String accessToken) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;

        this.state = state;
        this.accessToken = accessToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }
}