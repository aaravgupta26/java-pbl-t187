package ui;

import javax.swing.*;

public class ResultGUI extends JFrame {

    public ResultGUI(String name, int score, int total) 
    {

        setTitle("Quiz Result");
        setSize(400, 350);
        setLayout(null);

        double percent = (score * 100.0) / total;

        JLabel title = new JLabel("QUIZ RESULT");
        title.setBounds(130, 20, 200, 30);

        JLabel l1 = new JLabel( "Name: " + name);
        JLabel l2 = new JLabel("Score: " + score + " / " + total);
        JLabel l3 = new JLabel("Percentage: " + String.format("%.2f", percent) + "%");

        String msg;
        if (percent >= 80) msg = "Excellent ";
        else if (percent >= 50) msg = "Good ";
        else msg = "Needs Improvement ";

        JLabel l4 = new JLabel("Performance: " + msg);

        l1.setBounds(80, 80, 250 , 30);
        l2.setBounds( 80, 110, 250, 30);
        l3.setBounds(80, 140, 250, 30 );
        l4.setBounds(80, 170,250, 30);

        JButton back = new JButton("Back to Menu");
        back.setBounds(120, 230, 150, 30);

        back.addActionListener(e -> 
        {
            new main.MainApp();
            dispose();
        });

        add(title);
        add(l1); add(l2); add(l3); add(l4);
        add(back);

        setVisible(true);
    }
}