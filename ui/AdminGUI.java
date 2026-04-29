package ui;

import javax.swing.*;
import java.io.FileWriter;

public class AdminGUI extends JFrame {

    public AdminGUI() 
    {

        String pass = JOptionPane.showInputDialog("Enter Admin Password:");

        if (!"admin123".equals(pass)) 
        
        {
            JOptionPane.showMessageDialog(this, "Wrong Password");
            return;
        }

        setTitle("Admin Panel");
        setSize(450, 450);
        setLayout(null);

        JLabel title = new JLabel("ADD NEW QUESTION");
        JLabel lq = new JLabel("Question:");
        JLabel l1 = new JLabel("Option 1:");
        JLabel l2 = new JLabel("Option 2:");
        JLabel l3 = new JLabel("Option 3:");
        JLabel l4 = new JLabel("Option 4:");
        JLabel lans = new JLabel("Correct Option (1-4):");

        JTextField q = new JTextField();
        JTextField o1 = new JTextField();
        JTextField o2 = new JTextField();
        JTextField o3 = new JTextField();
        JTextField o4 = new JTextField();
        JTextField ans = new JTextField();

        JButton add = new JButton("Add Question");
        JButton clear = new JButton("Clear");
        JButton back = new JButton("Back");

        title.setBounds(130, 10, 200, 30);

        lq.setBounds(50, 50, 150, 20);
        q.setBounds(50, 70, 300, 30);

        l1.setBounds(50, 110, 150, 20);
        o1.setBounds(50, 130, 300, 30);

        l2.setBounds(50, 170, 150, 20);
        o2.setBounds(50, 190, 300, 30);

        l3.setBounds(50, 230, 150, 20);
        o3.setBounds(50, 250, 300, 30);

        l4.setBounds(50, 290, 150, 20);
        o4.setBounds(50, 310, 300, 30);

        lans.setBounds(50, 350, 200, 20);
        ans.setBounds(50, 370, 300, 30);

        add.setBounds(50, 410, 130, 30);
        clear.setBounds(190, 410, 80, 30);
        back.setBounds(280, 410, 80, 30);

        add(title);
        add(lq); add(q);
        add(l1); add(o1);
        add(l2); add(o2);
        add(l3); add(o3);
        add(l4); add(o4);
        add(lans); add(ans);

        add(add);
        add(clear);
        add(back);

        add.addActionListener(e -> 
        {
            try 
            {

                if (q.getText().isEmpty() || o1.getText().isEmpty() ||
                    o2.getText().isEmpty() || o3.getText().isEmpty() ||
                    o4.getText().isEmpty() || ans.getText().isEmpty()) 
                {

                    JOptionPane.showMessageDialog(this, "Fill all fields!");
                    return;
                }

                int correct = Integer.parseInt(ans.getText());

                if (correct < 1 || correct > 4) 
                {
                    JOptionPane.showMessageDialog(this, "Answer must be 1-4");
                    return;
                }

                FileWriter fw = new FileWriter("questions.txt", true);

                fw.write(q.getText() + "|" +
                         o1.getText() + "|" +
                         o2.getText() + "|" +
                         o3.getText() + "|" +
                         o4.getText() + "|" +
                         correct + "\n");

                fw.close();

                JOptionPane.showMessageDialog(this, "Question Added!");

            } catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        clear.addActionListener(e -> 
        {
            q.setText("");
            o1.setText("");
            o2.setText("");
            o3.setText("");
            o4.setText("");
            ans.setText("");
        });

        back.addActionListener(e -> 
        {
            new main.MainApp();
            dispose();
        });

        setVisible(true);
    }
}