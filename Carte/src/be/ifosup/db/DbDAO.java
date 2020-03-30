package be.ifosup.db;

import java.sql.*;

public class DbDAO {
    public static Connection initializeDatabase()
            throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/carte?serverTimezone=UTC";
        String user = "root";
        String password = "";
        Connection connection = null;


        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return connection;
    }
}

