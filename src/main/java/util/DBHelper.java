package util;

import java.io.File;
import java.io.FileInputStream;
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


    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
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


}
