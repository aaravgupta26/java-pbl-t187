package main;

import javax.swing.*;
import ui.*;

public class MainApp extends JFrame {

    public MainApp() 
    {

        setTitle("QUIZMATE");
        setSize(400, 300);
        setLayout(null);

        JButton start = new JButton("Start Quiz");
        JButton leader = new JButton("Leaderboard");
        JButton admin = new JButton("Admin Panel");

        start.setBounds(120, 50, 150, 30);
        leader.setBounds(120, 100, 150, 30);
        admin.setBounds(120, 150, 150, 30);

        add(start); add(leader); add(admin);

        start.addActionListener(e -> new QuizGUI());
        leader.addActionListener(e -> new LeaderboardGUI());
        admin.addActionListener(e -> new AdminGUI());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new MainApp();
    }
}