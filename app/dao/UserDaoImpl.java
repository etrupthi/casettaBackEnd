package dao;

        import com.google.common.collect.ImmutableList;

        import java.util.Collection;
        import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private User user;

    @Override
    public User create(User entity) {
        user = entity;
        return user;
    }

    @Override
    public Optional<User> read(Integer id) {
        return Optional.of(user);
    }

    @Override
    public User update(User entity) {
        user = entity;
        return user;
    }

    @Override
    public User delete(Integer id) {
        user = null;
        return user;
    }

    @Override
    public Collection<User> all() {
        return ImmutableList.of(user);
    }

    @Override
    public User findUserByName(String username) {
        return user;
    }

    @Override
    public User findUserByAuthToken(String authToken) {
        return user;
    }
}
