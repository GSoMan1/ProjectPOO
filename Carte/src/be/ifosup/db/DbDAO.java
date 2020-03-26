package be.ifosup.db;

import java.sql.*;

public class DbDAO {
    public static Connection initializeDatabase()
            throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Ok");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/carte?serverTimezone=UTC";
        String user = "root";
        String password = "";
        Connection connection = null;
//        Statement statement=null;
//        ResultSet resultat=null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Open");
        } catch (SQLException e) {
            System.out.println(e);
        }

//        try {
//            statement = connection.createStatement();
//            PreparedStatement requete = connection.prepareStatement("SELECT * FROM dishes");
//            resultat = requete.executeQuery();
//            if (resultat.next()){
//                action=true;
//            }
//        }
//        catch (SQLException e) {
//            System.out.println("Request Error");
//        }

//        finally {
//            if ( resultat != null) {
//                resultat.close();
//            }
//            if ( statement != null){
//                resultat.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
        return connection;
    }
}

