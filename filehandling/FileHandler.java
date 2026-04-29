package filehandling;

import java.io.*;
import java.util.*;
import model.Question;

public class FileHandler {

    public static ArrayList<Question> loadQuestions() 
    {
        ArrayList<Question> list = new ArrayList<>();

        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("questions.txt"));
            String line;

            while ((line = br.readLine()) != null) 
            {
                String p[] = line.split("\\|");

                if (p.length == 6) 
                {
                    list.add(new Question(p[0], p[1], p[2], p[3], p[4],Integer.parseInt(p[5])));
                }
            }
            br.close();
        } catch (Exception e) 
        {
            System.out.println("Error loading questions");
        }

        return list;
    }

    public static void saveResult(String name, int score, int total) 
    {
        try 
        {
            FileWriter fw = new FileWriter("results.txt", true);
            fw.write(name + "|" + score + "|" + total + "\n");
            fw.close();
        } catch (Exception e) 
        {
            System.out.println("Error saving result");
        }
    }

    public static ArrayList<String> loadResults() 
    {
        ArrayList<String> list = new ArrayList<>();

        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("results.txt"));
            String line;

            while ((line = br.readLine()) != null) 
            {
                list.add(line);
            }
            br.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Error loading results");
        }

        return list;
    }
}