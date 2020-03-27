package be.ifosup.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

public class ServiceDishes  {
    private static ConsoleHandler resultat;
    //todo

    public List<List<String>> GetDishes() throws SQLException {

        List<List<String>> dishes = new ArrayList<>();
//    private Statement stmt;
        Connection connection = DbDAO.initializeDatabase();

        try {
//          Statement statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT * FROM dishes");
            ResultSet resultat = requete.executeQuery();
            ResultSetMetaData rsmd = resultat.getMetaData();
            while (resultat.next()) {
                List<String> Dish = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    Dish.add(resultat.getString(i));
                }
                dishes.add(Dish);
            }
        } catch (SQLException e) {
            System.out.println("Request Error");
        }

        finally {
            if (resultat != null) {
                resultat.close();
            }
//            if (statement != null) {
//                resultat.close();
//            }
            if (connection != null) {
                connection.close();
            }

        }
        return dishes;
    }
}
