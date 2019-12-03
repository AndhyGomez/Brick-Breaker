/**
 * @author: Andhy Gomez
 * St.Thomas University
 * COP:1800 - Intro to Java Programming
 * 
 * Description: Holds the algorithm for the brick breaker game from collision detection
 * to movement and direction of the ball and platform.
 */

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


public class GameLogic extends JPanel implements KeyListener, ActionListener 
{
	// Initialize variables
	private boolean play = false;
	
	// Starting score and number of bricks
	private int score = 0;
	private int numBricks = 28;
	
	// Object to hold time and attribute to ball speed
	private Timer gameTime;
	private int delay = 8;
	
	// X coordinate for player
	private int playerXvalue = 310;
	
	// Starting coordinates for the ball
	private int ballX = 200;
	private int ballY = 330;
	
	// Set the initial directions the ball will travel
	private int ballDirX = 1;
	private int ballDirY = 2;
	
	// Initialize new BrickMap instance
	private BrickMap map;
	
	/**
	 * Constructor which declares map of bricks 
	 * and creates a timer object instance.
	 */
	public GameLogic()
	{	
		// Initialize new map of 4 rows by 7 columns
		map = new BrickMap(4,7);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		// Instance of Timer
		gameTime = new Timer(delay, this);
		gameTime.start();	
	}
	
	/**
	 * Creates graphics for Score counter, borders, platform, ball.
	 * Also holds logic for determining when any particular game should
	 * be considered over. (i.e. win or loss)
	 */
	public void paint(Graphics sprite)
	{
		// Add a background
		sprite.setColor(Color.black);
		sprite.fillRect(1, 1, 692, 592);
		
		// Draw bricks from BrickMap class
		map.draw((Graphics2D)sprite);
		
		// Display score
		sprite.setColor(Color.white);
		sprite.setFont(new Font("helvetica", Font.BOLD, 20));	
		sprite.drawString("SCORE: " + score, 570, 35);
		
		// Create borders
		sprite.setColor(Color.blue);
		sprite.fillRect(0, 0, 3, 592);
		sprite.fillRect(0, 0, 692, 3);
		sprite.fillRect(691, 0, 3, 592);
		
		// Create platform
		sprite.setColor(Color.white);
		sprite.fillRect(playerXvalue, 550, 100, 8);
		
		// Create the ball
		sprite.setColor(Color.red);
		sprite.fillOval(ballX, ballY, 20, 20);
		
		// Determine if player has won
		if(numBricks <= 0) 
		{
			// Switch boolean to false
			play = false;
			
			// Stop the ball
			ballDirX = 0;
			ballDirY = 0;
			
			// Display winner text
			sprite.setColor(Color.green);
			sprite.setFont(new Font("helvetica", Font.BOLD, 40));
			sprite.drawString("WINNER!", 260, 250);
			sprite.setFont(new Font("helvetica", Font.BOLD, 25));
			sprite.drawString("SCORE: " + score, 285, 300);
			sprite.setFont(new Font("helvetica", Font.BOLD, 25));
			sprite.drawString("Press enter to restart", 220, 350);
			
		}

  
		if(ballY > 570) 
		{
			// Switch boolean to false
			play = false;
			
			// Stop the ball
			ballDirX = 0;
			ballDirY = 0;
			
			// Display Game over text
			sprite.setColor(Color.red);
			sprite.setFont(new Font("helvetica", Font.BOLD, 35));
			sprite.drawString("GAME OVER", 230, 250);
			sprite.setFont(new Font("helvetica", Font.BOLD, 25));
			sprite.drawString("SCORE: " + score, 270, 300);
			sprite.setFont(new Font("helvetica", Font.BOLD, 25));
			sprite.drawString("Press enter to restart", 210, 350);
		
		}
		
		sprite.dispose();
	}
	
	/**
	 * KeyEvents which interpret what action to perform based
	 * on specific key pressed.
	 */
	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			// Checks if platform is still within bounds
			if(playerXvalue >= 600)
			{
				playerXvalue = 600;
			}
			else
			{
				moveRight();
			}
		
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			// Checks if platform is still within bounds
			if(playerXvalue <= 10)
			{
				playerXvalue = 10;
			}
			else
			{
				moveLeft();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) 
		{
			if(!play) 
			{
				// Create new History object
				History hist = new History();
				
				/*
				 * Once each game ends, the score of the previous game will be 
				 * appended to history.txt file
				 */
				try 
				{
					hist.writeScore(score);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
				// Reset all values for user to play again
				play = true;
				
				ballX = 120;
				ballY = 320;
				
				ballDirX = 2;
				ballDirY = 2;
				
				playerXvalue = 310;
				
				score = 0;
				numBricks = 28;
				map = new BrickMap(4,7);
				
				repaint();
    
			}
		}
	}
	
	/**
	 * Holds logic for intersections/collisions
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Starts timer
		gameTime.start();
		
		if(play)
		{
			/* Detects if ball intersects with platform by creating rectangles
			 * around the ball and platform
			 */
			if(new Rectangle(ballX, ballY, 20,20).intersects(new Rectangle(playerXvalue, 550, 100, 8)))
			{
				ballDirY = -ballDirY;
			}
			
			/*
			 * 'A' allows for break point to fully break out of outer loop
			 * as opposed to only breaking out of inner for loop.
			 */
			A: for(int i = 0; i < map.map.length; i++) 
			{
				for(int j = 0; j < map.map[0].length; j++) 
				{
					if(map.map[i][j] > 0) 
				    {
						int brickX = j * map.brickWidth + 80;
					    int brickY = i * map.brickHeight + 50;
					    int brickWidth = map.brickWidth;
					    int brickHeight = map.brickHeight;
				      
					    Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
					    Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
					    Rectangle brickRect = rect;
					    
					    // Collision between ball and brick
					    if(ballRect.intersects(brickRect)) 
					    {
					    	map.setBrick(0, i, j);
					    	numBricks--;
					    	score+=5;
					    	
					    	/*
					    	 * Determines direction ball will move once
					    	 * it collides with a brick.
					    	 */
					    	if(ballX + 19 <= brickRect.x || ballY +1 >= brickRect.x + brickRect.width) 
					    	{
					    		ballDirX = -ballDirX;
					    	}
					    	else 
					    	{
					    		ballDirY = -ballDirY;
					    	}
					    	
					    	// Breaks out of outer for loop
					    	break A;
					    	
					    }
				     }
				}
				    
			}
		
			// Logic which will ensure the ball stays within frame
			ballX += ballDirX;
			ballY += ballDirY;
			
			if(ballX < 0)
			{
				ballDirX = -ballDirX;
			}
			if(ballY < 0)
			{
				ballDirY = -ballDirY;
			}
			if(ballX > 670)
			{
				ballDirX = -ballDirX;
			}
		}
		
		// Repaints shapes when they move
		repaint();
		
	}
	
	/**
	 * Method for moving the platform to the right
	 * (Adds 20 to current x-coordinate.
	 */
	public void moveRight()
	{
		play = true;
		playerXvalue += 20;
	}
	
	/**
	 * Method for moving the platform to the left
	 * (Subtracts 20 from current x-coordinate.
	 */
	public void moveLeft()
	{
		play = true;
		playerXvalue -= 20;
	}
	
/*
	 
		Required to compile 
*******************************************

*/

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	

}
