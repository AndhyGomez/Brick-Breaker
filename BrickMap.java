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
	
	// Create a constructor
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
	
	public void setBrick(int value, int r, int c)
	{
		// Assign values to bricks
		map[r][c] = value;
	}
	
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
	
