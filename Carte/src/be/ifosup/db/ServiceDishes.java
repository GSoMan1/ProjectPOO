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
        Connection connection = DbDAO.initializeDatabase();

        try {
            PreparedStatement requete = connection.prepareStatement("SELECT * FROM dishes");
            ResultSet resultat = requete.executeQuery();
            ResultSetMetaData rsmd = resultat.getMetaData();

            while(resultat.next()){
                String title = resultat.getString("title");
                String description = resultat.getString("description");
                float price = resultat.getFloat("price");
                int id = resultat.getInt("id");
                Dish dish = new Dish(title,description,price,id);
                dishes.add(dish);
            }

        } catch (SQLException e) {
            System.out.println("Request Error");
        }

        finally {
            if (resultat != null) {
                resultat.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
        return dishes;
    }
}

