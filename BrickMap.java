/**
 * @author: Andhy Gomez
 * St.Thomas University
 * COP:1800 - Intro to Java Programming
 * 
 * Description: Persistent code which uses a 2D Array in order to to create a map
 * of bricks to be called in GameLogic.Java file.
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class BrickMap 
{
	// Initialize 2D Map array
	public int[][] map;
	
	// Initialize variables
	public int brickWidth;
	public int brickHeight;
	
	/**
	 * Constructor for BrickMap
	 * 
	 * @param row number of rows of bricks
	 * @param col number of columns of bricks
	 */
	public BrickMap(int row, int col)
	{
		// Generate the new map
		map = new int[row][col];
		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				// Detects each individual brick by coordinate 
				map[i][j] = 1;
			}
		}
		
		// Divide total map width by number of columns
		brickWidth = 540/col;
		
		// Divide total map height by number of rows
		brickHeight = 150/row;
		
	}
	
	/**
	 * Assigns value to bricks
	 * 
	 * @param value If brick is destroyed, value = 0
	 * @param r Row of brick
	 * @param c Column of brick
	 */
	public void setBrick(int value, int r, int c)
	{
		// Assign values to bricks
		map[r][c] = value;
	}
	
	/**
	 * Contains the code for the creation of the 
	 * map of bricks.
	 * @param sprite: Name of graphics created
	 */
	public void draw(Graphics2D sprite)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				// Determines if brick needs to be created or not
				if(map[i][j] > 0)
				{
					sprite.setColor(Color.cyan);
					
					// fill dimensions of each brick
					sprite.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
					// Create border around each brick
					sprite.setStroke(new BasicStroke(3));
					sprite.setColor(Color.black);
					sprite.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
	}
}
	
