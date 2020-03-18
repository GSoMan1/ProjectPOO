package be.ifosup.login;

import java.sql.*;

public class LoginDAO {
    protected static void initializeDatabase()
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
//            PreparedStatement requete = connection.prepareStatement("SELECT * FROM  login WHERE user = ? and password = ?");
//            requete.setString(1,nom);
//            requete.setString(2,pass);
//            resultat = requete.executeQuery();
//            if (resultat.next()){
//                action=true;
//            }
//        }
//        catch (SQLException e) {
//            System.out.println("Request Error");
//        }

        finally {
//            if ( resultat != null) {
//                resultat.close();
//            }
//            if ( statement != null){
//                resultat.close();
//            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}

