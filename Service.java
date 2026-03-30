package features;

import java.util.*;
import java.io.*;
import model.Question;

public class Service 
{

    private List<Question> questions = new ArrayList<>();

    public Service() 
    {
        loadQuestionsFromFile();
    }

    private void loadQuestionsFromFile() 
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("questions.txt"));
            String line;

            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split("\\|");

                String question = parts[0];
                String[] options = parts[1].split(",");
                int correct = Integer.parseInt(parts[2]);

                questions.add(new Question(question, options, correct));
            }

            br.close();

        } catch (Exception e) 
        {
            System.out.println("Error reading questions file");
        }
    }

    public int startQuiz() 
    {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (Question q : questions) 
        {
            System.out.println("\n" + q.getQuestion());

            String[] opts = q.getOptions();
            for (int i = 0; i < opts.length; i++) 
            {
                System.out.println((i + 1) + ". " + opts[i]);
            }

            System.out.print("Enter answer: ");
            int ans = sc.nextInt();

            if (ans == q.getCorrectAnswer()) 
            {
                score++;
            }
        }

        return score;
    }
}