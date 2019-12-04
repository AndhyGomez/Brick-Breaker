/**
 * @author: Andhy Gomez
 * St.Thomas University
 * COP:1800 - Intro to Java Programming
 * 
 * Description: A clone of traditional brick breaker games such as breakout ball
 * written in JavaSE-12 for my Intro to Java Term Project.
 */

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Main 
{
	/**
	 * Sets bounds, title, etc.. for 
	 * JFrame to display game.
	 * @param args main 
	 */
	public static void main(String[] args) throws IOException 
	{
		// Initialize variable 
		String name;
		
		// Ask user for name
		name = JOptionPane.showInputDialog("Enter your name: ");

		// Create new History object
		History hist = new History();
		
		// Write name to History.txt
		hist.writeName(name);
		
		// Create Frame and set methods
		JFrame mainFrame = new JFrame();
		
		// Create a GameLogic instance
		GameLogic game = new GameLogic();
		
		mainFrame.setBounds(10,10,700,600);
		mainFrame.setTitle("Brick Breaker");
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.add(game); // add it to the initial frame
		
		// Set graphics to be visible
		mainFrame.setVisible(true);
		
	}

}
