package service;

import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;
import user.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoJDBCImpl();
    private static UserServiceImpl instance;


    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);

    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String name) throws SQLException {
        return userDao.getUserByName(name);
    }
}
