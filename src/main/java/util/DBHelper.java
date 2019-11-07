package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import user.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    private static DBHelper instance;
    private static final String URL = "jdbc:mysql://localhost:3306/jm_schema";
    private static final String PASSWORD = "root";
    private static final String LOGIN = "root";
    private Connection connection;
    private static SessionFactory sessionFactory;


    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, PASSWORD, LOGIN);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Ошибка в подключении драйвера или соединении");
        }
        return connection;
    }

    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", "dialect");
        configuration.setProperty("hibernate.connection.driver_class", "driver.class");
        configuration.setProperty("hibernate.connection.url", "connection.url");
        configuration.setProperty("hibernate.connection.username", "username");
        configuration.setProperty("hibernate.connection.password", "password");
        configuration.setProperty("hibernate.show_sql", "show_sql");
        configuration.setProperty("hibernate.hbm2ddl.auto", "hbm2ddl.auto");
        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        org.hibernate.service.ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);

    }

}
