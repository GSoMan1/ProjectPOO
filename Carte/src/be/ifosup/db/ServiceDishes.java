package be.ifosup.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import be.ifosup.entities.*;
import com.mysql.cj.jdbc.MysqlDataSourceFactory;


public class ServiceDishes  {
    private static ConsoleHandler resultat;
    //todo

    public static List<Dish> GetDishes(int catid) throws SQLException {

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
                Float price = resultat.getFloat("price");
                int id = resultat.getInt("id");
                Category category = ServiceCategories.GetCategoryByID(resultat.getInt("catid"));
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

    public static void deldish(int id) throws SQLException {

        String sql = "DELETE FROM dishes WHERE id = ?";
        System.out.println("deldish service " +id);
        Connection connection = DbDAO.initializeDatabase();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public static Dish GetDishByID(int id) throws SQLException {

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
                Category category = ServiceCategories.GetCategoryByID(resultat.getInt("catid"));
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
}

//      sql = "INSERT INTO category (title, description, price, catid) WHERE id = ";
//        else
//            sql ="UPDATE SET title = ? , description = ?, price = ?, catid = ? FROM category WHERE id = ?";

