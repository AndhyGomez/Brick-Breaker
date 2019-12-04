/**
 * @author: Andhy Gomez
 * St.Thomas University
 * COP:1800 - Intro to Java Programming
 * 
 * Description: Holds the code which will be used to write 
 * the scores of each game played.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class History
{
	//File that will be used throughout the code
	File file = new File("History.txt");

	/**
	 * Method which can be used to write a name 
	 * to the history.txt file
	 * 
	 * @param name the name to write to the file
	 * @throws IOException disregards IO exceptions
	 */
	public void writeName(String name) throws IOException
	{	
		//Scanner inputFile = new Scanner(file);
		
		FileWriter fw = new FileWriter(file, true);
		PrintWriter outputFile = new PrintWriter(fw);
		
		// Write to file
		outputFile.println("Player: " + name);	
		
		// Close the file
		outputFile.close();

	}
	
	/**
	 * Method to write score to history.txt file
	 * 
	 * @param score the value to be written to file
	 * @throws IOException disregards IO exceptions
	 */
	public void writeScore(int score) throws IOException
	{
		//Scanner inputFile = new Scanner(file);
		
		FileWriter fw = new FileWriter(file, true);
		PrintWriter outputFile = new PrintWriter(fw);

		//Write game results to file 
		outputFile.print("Score: " + score + "\n");	
		
		// Close the file
		outputFile.close();
	}
}
