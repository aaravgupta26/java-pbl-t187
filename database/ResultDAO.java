package database;

import java.sql.*;

public class ResultDAO {

    public static void saveResult(String name, int score, int total) 
    {

        try 
        {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO results(name, score, total) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, score);
            ps.setInt(3, total);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) 
        {
            System.out.println("Error saving to database");
        }
    }
}