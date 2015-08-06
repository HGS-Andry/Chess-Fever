package model;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Pawn class
 * @author Andrea
 *
 */
public class Pawn extends Piece {
	int steps;
	
	/**
	 * Constructor for the Pawn. It set the steps to 0
	 */
	public Pawn(Color color, Coordinates position, Model model){
		super(color, position, model);
		steps=0;
	}
	
	/**
	 * increment the pawn's step counter and return it's value
	 */
	public int incrementSteps(){
		return ++steps;
	}
	
	/**
	 * return the step's counter
	 */
	public int getSteps(){
		return steps;
	}
		

	@Override
	public void calculateMoves() {
		//reset
		moveCoord.clear();
		// firstmove
		if (pieceColor==Color.BLACK){
			//calculate the coordinate, then check if free and first move
			Coordinates tmpCoord=new Coordinates(this.position.getXCCoordinate(), this.position.getYRCoordinate()+2);
			if (model.getPieceAt(tmpCoord)==null && steps==0)
				moveCoord.add(tmpCoord);
			//Check if free
			tmpCoord=new Coordinates(this.position.getXCCoordinate(), this.position.getYRCoordinate()+1);
			if (model.getPieceAt(tmpCoord)==null)
				moveCoord.add(tmpCoord);
		}
		if (pieceColor==Color.BLACK){
			//calculate the coordinate, then check if free and first move
			Coordinates tmpCoord=new Coordinates(this.position.getXCCoordinate(), this.position.getYRCoordinate()-2);
			if (model.getPieceAt(tmpCoord)==null && steps==0)
				moveCoord.add(tmpCoord);
			//Check if free
			tmpCoord=new Coordinates(this.position.getXCCoordinate(), this.position.getYRCoordinate()-1);
			if (model.getPieceAt(tmpCoord)==null)
				moveCoord.add(tmpCoord);
		}
		model.setMovesList(moveCoord);
	}


	@Override
	public void calculateKills() {
		// TODO Auto-generated method stub
		
	}
}
