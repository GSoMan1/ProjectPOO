package be.ifosup.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import be.ifosup.entities.Dish;

public class ServiceDishes  {
    private static ConsoleHandler resultat;
    //todo

    public static List<Dish> GetDishes() throws SQLException {

        List<Dish> dishes = new ArrayList<Dish>();
//    private Statement stmt;
        Connection connection = DbDAO.initializeDatabase();

        try {
//          Statement statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT * FROM dishes");
            ResultSet resultat = requete.executeQuery();
            ResultSetMetaData rsmd = resultat.getMetaData();

            while(resultat.next()){
                String title = resultat.getString("title");
                String description = resultat.getString("description");
                Dish dish = new Dish(title,description,0);
                dishes.add(dish);
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

