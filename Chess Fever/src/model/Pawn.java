package model;

import java.util.Collection;


/**
 * Pawn class
 * @author Andrea
 *
 */
public class Pawn extends Piece {
	int steps;
	
	public Pawn(Color color){
		super(color);
		steps=0;
	}
	
	@Override
	public Collection <Coordinates> getMoves(Coordinates coord){
		
	}
}
