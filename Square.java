
import java.awt.Color;
import java.awt.Graphics;

/**
 *{@summary} Squares are represented by the (x,y) position of the upper left corner, and their size. 
 *Squares also have a randomly generated color. 
 *@author Warisa Khan 
 */

public class Square {
	/**
	 *  The next id when a new square is created.
	 */
	private static int nextID = 0;
	
	/**
	 *  The X position of the upper left corner of this square.
	 */
	private int upperLeftX;
	
	/**
	 *  The Y position of the upper left corner of this square.
	 */
	private int upperLeftY;
	
	/**
	 *  The size of this square.
	 */
	private int size;
	
	/**
	 *  The color this square.
	 */
	private Color color;
	
	/**
	 *  The id of this square.
	 */
	private int id;
	
	/**
	 *  Initialize a square with the given position (specified 
	 *  relative to the WindowManager in which all this is being
	 *  run), dimensions, and color.
	 *  
	 *  @param centerX the x position of the center of this square
	 *  @param centerY the y position of the center of this square
	 *  @param size the size of this square
	 *  @param c the color of this square
	 */
	public Square (int centerX, int centerY, int size, Color c) {
		this.upperLeftX = centerX - size/2;
		this.upperLeftY = centerY - size/2;
		this.size = size;
		this.color = c;
		this.id = nextID;
		nextID++;
	}

	/**
	 * a boolean that checks to see if the x and y position is contained within the square.
	 * @param x is the x value being checked.
	 * @param y is the y value being checked.
	 * @return boolean, if (x,y) in square, return true, otherwise return false.
	 */

	public boolean contains (int x, int y) {
		//Returns whether or not a given x and y
		//position are contained within this square.

		if (x >= this.upperLeftX && x <= this.upperLeftX + this.size && y >= this.upperLeftY && y <= this.upperLeftY + this.size){
			return true;
		}
		//< YOUR_CODE_HERE >
		
		//Note: upper left x and y are _inclusive_.
		
		return false; //dummy return, replace this!
	}

	/**
	 *  Fetches the id of this square.
	 *  
	 *  @return the id of this square
	 */
	public int id() {
		return id;
	}
	
	/**
	 *  Gets the upper left x position of the square.
	 *  
	 *  @return the upper left x position
	 */
	public int getUpperLeftX() {
		return upperLeftX;
	}
	
	/**
	 *  Gets the upper left y position of the square.
	 *  
	 *  @return the upper left y position
	 */
	public int getUpperLeftY() {
		return upperLeftY;
	}
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals (Object o) {
		if(o instanceof Square) {
			Square sq = (Square) o;
			return upperLeftX == sq.upperLeftX && 
				upperLeftY == sq.upperLeftY && 
				size == sq.size;
		}
		return false;
	}
	
	/**
	 *  Draw the square, surrounded by a border.
	 *  Utilzing built in functions setColor(), drawRect(), and fillRect() to complete this method. 
	 *  @param g the graphics to paint on, assumed not null
	 */
	public void paint (Graphics g) {

		g.setColor(color);
		g.fillRect(this.upperLeftX, this.upperLeftY, this.size, this.size);
		
		// will this just set the outer part as black? or fill the whole thing in?
		g.setColor(Color.black);
		g.drawRect(this.upperLeftX, this.upperLeftY, this.size, this.size);
		


		//Draws a square on the graphics (g) using methods outlined in
		//the project description.
		
		//You should draw a filled square-shaped-rectangle using
		//the color of this square. You should then draw a black
		//border in the same space.
		
		//< YOUR_CODE_HERE >
	}
}
