package ui;

import javax.swing.*;
import java.awt.event.*;

public class QuizGUI 
{
	
	public QuizGUI()
	{
		JFrame frame = new JFrame("QuizMate");
		JButton startBtn = new JButton("start quiz");
		
		startBtn.setBounds(100,100,150,40);
		
		startBtn.addActionListener(new ActionListener()
				{
			       public void actionPerformed(ActionEvent e)
			       {
			    	     System.out.println("GUI");
			       }
				});
		
		frame.add(startBtn);
		frame.setSize(400,300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
 
}
