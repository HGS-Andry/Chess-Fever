package model;

/**
 * Coordinate class
 * @author Andrea Dall'Alba
 *
 */
public class Coordinates {
	private int x, y;
	
	/**
	 * Constructor base for a coordinate
	 * @param x x coord
	 * @param y y coord
	 */
	public Coordinates(int x, int y) {
		this.x=x;
		this.y=y;
		}
	
	/**
	 * get the x (Column) value
	 */
	public int getXCCoordinate(){
		return x;
	}
	
	/**
	 * get the y (Row) value
	 */
	public int getYRCoordinate(){
		return y;
	}
}
