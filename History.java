import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class History
{
	//File that will be used throughout the code
	File file = new File("History.txt");

	public void writeName(String name) throws IOException
	{	
		//Scanner inputFile = new Scanner(file);
		
		FileWriter fw = new FileWriter(file, true);
		PrintWriter outputFile = new PrintWriter(fw);
		
		// Write to file
		outputFile.print(name + " ");	
		
		// Close the file
		outputFile.close();

	}
	
	public void writeScore(int score) throws IOException
	{
		//Scanner inputFile = new Scanner(file);
		
		FileWriter fw = new FileWriter(file, true);
		PrintWriter outputFile = new PrintWriter(fw);

		//Write game results to file 
		outputFile.print(score + "\n");	
		
		// Close the file
		outputFile.close();
	}
}
