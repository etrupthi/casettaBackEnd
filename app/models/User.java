
package models;

public class User {
    public enum Role {
        ADMIN,
        USER
    }

    public enum State {
        PENDING,
        VERIFIED,
        LOCKED
    }

    Integer id;
    String username;
    String email;
    String password;
    Role role;
    State state;
    String accessToken;
    // expiration
    // refreshToken
}