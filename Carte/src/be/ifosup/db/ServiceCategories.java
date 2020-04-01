package be.ifosup.db;

import be.ifosup.entities.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

public class ServiceCategories {
    private static ConsoleHandler resultat;

    public static List<Category> getCategories() throws SQLException {

        List<Category> categories = new ArrayList<Category>();
        Connection connection = DbDAO.initializeDatabase();

        try {

            PreparedStatement requete = connection.prepareStatement("SELECT * FROM categories");
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

    public static Category getCategoryByID(int catid) throws SQLException {

        Connection connection = DbDAO.initializeDatabase();

        Category category = null;
        try {
            PreparedStatement requete = connection.prepareStatement("SELECT * FROM categories WHERE id="+catid);
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

    public static void delCategory(int id) throws SQLException {

        String sql = "DELETE FROM categories WHERE id = ?";
        String sql2 ="DELETE FROM dishes WHERE catid = ?";
        Connection connection = DbDAO.initializeDatabase();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            PreparedStatement statement1 = connection.prepareStatement(sql2);
            statement.setInt(1, id);
            statement1.setInt(1, id);
            statement.executeUpdate();
            statement1.executeUpdate();
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

    public static void editCategory(Category category) throws SQLException {
        String sql;
        if (category.getId() == 0)
            sql = "INSERT INTO categories (categories.name) VALUES (?)";
        else
            sql = "UPDATE categories SET categories.name = ? WHERE id = ?";

        Connection connection = DbDAO.initializeDatabase();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getName());
            if (category.getId() != 0)
                statement.setInt(2, category.getId());
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
