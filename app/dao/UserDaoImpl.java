package dao;

import com.google.common.collect.ImmutableList;
import controllers.UsersController;
import models.Hotel;
import models.User;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private final static Logger.ALogger LOGGER = Logger.of(UsersController.class);

    final JPAApi jpaApi;



    @Inject
    public UserDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public User create(User user) {

        if (null == user) {
            throw new IllegalArgumentException("Book must be provided");
        }

        jpaApi.em().persist(user);
        return user;
    }

    @Override
    public Optional<User> read(String username) {

        if (null == username) {
            throw new IllegalArgumentException("username must be provided");
        }

        final User user = jpaApi.em().find(User.class, username);
        return user != null ? Optional.of(user) : Optional.empty();
    }



    @Override
    public User update(User user) {

        if (null == user) {
            throw new IllegalArgumentException("Book must be provided");
        }

        if (null == user.getUsername()) {
            throw new IllegalArgumentException("User must be provided");
        }

        final User existingUser = jpaApi.em().find(User.class, user.getUsername());
        if (null == existingUser) {
            return null;
        }

        existingUser.setUsername(user.getUsername());

        jpaApi.em().persist(existingUser);

        return existingUser;
    }


    @Override
    public User delete(String username) {

        if (null == username) {
            throw new IllegalArgumentException("Book id must be provided");
        }

        final User existingUser = jpaApi.em().find(User.class, username);
        if (null == existingUser) {
            return null;
        }

        jpaApi.em().remove(existingUser);

        return existingUser;
    }



    @Override
    public Collection<User> all() {

        TypedQuery<User> query = jpaApi.em().createQuery("SELECT b FROM Hotel b", User.class);
        List<User> users = query.getResultList();

        return users;
    }


//    @Override
//    public User findUserByName(String username) {
//
//        if (null == username) {
//            throw new IllegalArgumentException("Id must be provided");
//        }
//
//        final User user = jpaApi.em().find(User.class, username);
//        return user ;
//    }

    @Override
    public User findUserByAuthToken(String accessToken) {

        if (null == accessToken) {
            throw new IllegalArgumentException("auth token must be provided");
        }

        LOGGER.debug(accessToken);

        TypedQuery<User> query = jpaApi.em().createQuery("SELECT b FROM User b where accessToken = accessToken", User.class);
        User user = query.getSingleResult();


//        final User user = jpaApi.em().find(User.class, accessToken);

        //LOGGER.debug(user.getUsername());

       
        return user;

    }
}

