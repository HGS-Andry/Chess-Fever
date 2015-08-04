package model;

import java.util.Collection;

/**
 * Abstract class for define a Piece
 * @author Andrea Dall'Alba
 *
 */
public abstract class Piece {
	Color pieceColor;
	
	public Piece(Color color){
		this.pieceColor=color; 
	}
	
	abstract public Collection <Coordinates> getMoves(Coordinates coord);
}
