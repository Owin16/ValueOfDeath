package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {

    private static ConnectorDB instance;
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/valueofdeath";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "1111";

    private ConnectorDB() {
        try {
            Class.forName(DATABASE_DRIVER);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectorDB getInstance() {
        if (instance == null) {
            instance = new ConnectorDB();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            return null;
        }
    }

}
