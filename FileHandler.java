package fileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler 
{
	public static void saveResult(String name, int score)
	{
		try
		{
			FileWriter fw = new FileWriter("result.txt", true);
			fw.write(name + "score: " + score + "\n");
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
