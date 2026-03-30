package main;

import java.util.Scanner;
import model.User;
import ui.QuizGUI;
import features.Service;
import fileHandling.FileHandler;

public class Mainapp 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
			System.out.print("enter your name: ");
			String name = sc.nextLine();
			
			User user = new User(name);
			Service quiz = new Service();
			int score = quiz.startQuiz();
			
			System.out.println("\n final score: "+ score);
			FileHandler.saveResult(user.getName(), score);
			
			new QuizGUI();
			

	}

}
