package be.ifosup.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import be.ifosup.entities.*;


public class ServiceDishes  {
    private static ConsoleHandler resultat;

    public static List<Dish> getDishes(int catid) throws SQLException {

        List<Dish> dishes = new ArrayList<Dish>();
        Connection connection = DbDAO.initializeDatabase();

        try {
            String statement;
            if (catid == 0) {
                statement = "SELECT * FROM dishes";
            }else{
                statement = "SELECT * FROM dishes WHERE catid ="+catid;
            }
            PreparedStatement requete = connection.prepareStatement(statement);
            ResultSet resultat = requete.executeQuery();


            while(resultat.next()){
                String title = resultat.getString("title");
                String description = resultat.getString("description");
                float price = resultat.getFloat("price");
                int id = resultat.getInt("id");
                Category category = ServiceCategories.getCategoryByID(resultat.getInt("catid"));
                Dish dish = new Dish(title, description, price, id, category);
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

    public static void delDish(int id) throws SQLException {

        String sql = "DELETE FROM dishes WHERE id = ?";
        System.out.println("deldish service " +id);
        Connection connection = DbDAO.initializeDatabase();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public static Dish getDishByID(int id) throws SQLException {

        Dish dish = null;
        Connection connection = DbDAO.initializeDatabase();


        try {
            String statement = "SELECT * FROM dishes WHERE id = "+id;
            PreparedStatement requete = connection.prepareStatement(statement);
            ResultSet resultat = requete.executeQuery();


            if(resultat.next()){
                String title = resultat.getString("title");
                String description = resultat.getString("description");
                Float price = resultat.getFloat("price");
                int dishid = resultat.getInt("id");
                Category category = ServiceCategories.getCategoryByID(resultat.getInt("catid"));
                dish = new Dish(title, description, price, dishid, category);
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
        return dish;
    }

    public static void editDishes(Dish dish) throws SQLException {
        String sql;
        if (dish.getId() == 0)
            sql = "INSERT INTO dishes (title, description, price, catid) VALUES (?,?,?,?)";
        else
            sql ="UPDATE dishes SET title = ? , description = ?, price = ?, catid = ? WHERE id = ?";

        Connection connection = DbDAO.initializeDatabase();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, dish.getTitle());
            statement.setString(2, dish.getDescription());
            statement.setFloat(3, dish.getPrice());
            statement.setInt(4, dish.getCategory().getId());
            if (dish.getId() != 0)
                statement.setInt(5, dish.getId());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Request Error");
        }
        finally {
            if (connection != null) {
                connection.close();
            }

        }
    }
}



