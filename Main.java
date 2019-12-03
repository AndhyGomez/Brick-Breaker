import javax.swing.JFrame;

public class Main 
{

	public static void main(String[] args) 
	{
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
