package be.ifosup.db;

import be.ifosup.entities.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

public class ServiceCategories {
    private static ConsoleHandler resultat;

    public static List<Category> GetCategory() throws SQLException {

        List<Category> categories = new ArrayList<Category>();
        Connection connection = DbDAO.initializeDatabase();

        try {

            PreparedStatement requete = connection.prepareStatement("SELECT * FROM category");
            ResultSet resultat = requete.executeQuery();

            while(resultat.next()){
                String name = resultat.getString("name");
                int id = resultat.getInt("id");
                Category category = new Category(id, name);
                categories.add(category);
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
        return categories;
    }

    public static Category GetCategoryByID(int catid) throws SQLException {

        Connection connection = DbDAO.initializeDatabase();

        Category category = null;
        try {
            PreparedStatement requete = connection.prepareStatement("SELECT * FROM category WHERE id="+catid);
            ResultSet resultat = requete.executeQuery();


            if (resultat.next()) {
                String name = resultat.getString("name");
                int id = resultat.getInt("id");
                category = new Category(id, name);
            }else{

            }

        } catch (SQLException e) {
            System.out.println("Request Error");
        } finally {
            if (resultat != null) {
                resultat.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return category;
    }

    public static void delcategory(int id) throws SQLException {

        String sql = "DELETE FROM category WHERE id = ?";
        String sql2 ="DELETE FROM dishes WHERE catid = ?";
        System.out.println("category service " +id);
        Connection connection = DbDAO.initializeDatabase();
        PreparedStatement statement = connection.prepareStatement(sql);
        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement.setInt(1, id);
        statement1.setInt(1,id);
        statement.executeUpdate();
        statement1.executeUpdate();
    }

}
