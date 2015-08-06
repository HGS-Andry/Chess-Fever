package model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Abstract class for define a Piece
 * @author Andrea Dall'Alba
 *
 */
public abstract class Piece {
	protected final Color pieceColor;
	protected Coordinates position;
	protected Model model;
	protected ArrayList<Coordinates> moveCoord,killCoord;
	/**
	 * Create a Piece
	 * @param color The {@link Color} of the piece
	 * @param Position The {@link Coordinates} of the piece
	 */
	public Piece(Color color, Coordinates Position, Model model ){
		this.pieceColor=color;
		this.position=Position;
		this.model=model;
		moveCoord=new ArrayList<>();
		killCoord=new ArrayList<>();
	}
	
	/**
	 * Return the {@link Coordinates} of the current piece
	 */
	public Coordinates getPosition(){
		return position;
	}
	
	/**
	 * Return the {@link Color} of the current Piece
	 */
	public Color getColor(){
		return pieceColor;
	}
	
	/**
	 * Change the piece {@link Coordinates}
	 * @param position The new {@link Coordinates}
	 */
	public void setPosition(Coordinates position){
		this.position=position;
	}
	
	/**
	 * Return the possible moves for the piece
	 */
	abstract public void calculateMoves();
	
	/**
	 * Return the possible kills for the piece
	 */
	abstract public void calculateKills();
}
