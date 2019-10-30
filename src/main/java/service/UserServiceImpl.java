package service;

import dao.UserDaoJDBCImpl;
import user.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl userDaoJDBCImpl;
    private static UserServiceImpl instance;


    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        return userDaoJDBCImpl.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDaoJDBCImpl.addUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDaoJDBCImpl.deleteUser(id);

    }

    @Override
    public void editUser(User user) {
        userDaoJDBCImpl.editUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDaoJDBCImpl.getUserById(id);
    }

    @Override
    public User getUserByName(String name) throws SQLException {
        return userDaoJDBCImpl.getUserByName(name);
    }
}
