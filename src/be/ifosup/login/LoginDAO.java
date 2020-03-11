package be.ifosup.login;

import java.sql.*;

public class LoginDAO {
    public static boolean valid(String nom, String pass) throws SQLException {
        boolean action = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String url= "jdbc:mysql://localhost:3306/5IPO1?serverTimezone=UTC";
        String user= "root";
        String password= "";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connexion OK");
        }catch (SQLException e){
            System.out.println(e);
        }
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT * FROM login WHERE user= ? and password = ?");
            requete.setString(1,nom);
            requete.setString(2,pass);
            resultat =requete.executeQuery();
            if (resultat.next()){
                action=true;
            }
        }catch (SQLException e){
            System.out.println("Problème avec la requête");
        }finally {
            if (resultat != null){
                resultat.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return action;
    }
}
