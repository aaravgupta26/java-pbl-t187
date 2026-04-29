package ui;

import javax.swing.*;
import java.sql.*;
import database.DBConnection;

public class LeaderboardGUI extends JFrame {

    public LeaderboardGUI() 
    {

        setTitle("Leaderboard");
        setSize(400, 350);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        try 
        {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM results ORDER BY score DESC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            int rank = 1;

            area.append("------ TOP SCORES ------\n\n");

            while (rs.next()) 
            {
                area.append(
                    rank + ". " +
                    rs.getString("name") +
                    "  | Score: " +
                    rs.getInt("score") + "/" +
                    rs.getInt("total") + "\n"
                );
                rank++;
            }

            con.close();

        } catch (Exception e) 
        {
            System.out.println("Error loading leaderboard");
        }

        add(new JScrollPane(area));
        setVisible(true);
    }
}