/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * Interface for the model of the program
 * @author Andrea Dall'Alba
 *
 */
public interface Model {
	/**
	 * Return the actual position of the chessboard
	 */
	public Piece[][] getConfiguration();
	
	/**
	 * Return the {@link Piece} at given {@link Coordinates}
	 */
	public Piece getPieceAt(Coordinates coordinate);
	
	/**
	 * Return the list of black dead {@link Piece}
	 */
	public ArrayList<Piece> getBlackDeadlist();
	
	/**
	 * Return the list of white dead {@link Piece}
	 */
	public ArrayList<Piece> getWhiteDeadlist();
	
	
	/**
	 * Move a {@link Piece} in final {@link Coordinates}
	 * @param piece The {@link Piece} to move
	 * @param finalCoord the chess {@link Coordinates}
	 */
	public void move (Piece piece,Coordinates finalCoord);
	
	/**
	 * Move a {@link Piece} and kill the opposite Piece. This one will be placed in it's deadlist
	 * @param piece The {@link Piece} to move
	 * @param finalCoord the chess {@link Coordinates}
	 */
	public void kill (Piece piece,Coordinates finalCoord);

	/**
	 * Set the current {@link Piece}
	 */
	public void setCurrPiece(Piece piece);
	
	/**
	 * Get the current {@link Piece}
	 */
	public Piece getCurrPiece();
	
	/**
	 * Get a list of possible movement for the current piece
	 */
	public ArrayList<Coordinates> getMovesList();
	
	/**
	 * get a list of possible kills for the current piece
	 */
	public ArrayList<Coordinates> getKillList();
	
	/**
	 * set a list of possible movement for the current piece
	 */
	public void setMovesList(ArrayList<Coordinates> coordList);
	
	/**
	 * set a list of possible kills for the current piece
	 */
	public void setKillList(ArrayList<Coordinates> coordList);
	
	/**
	 * Clear the move and the kill list
	 */
	public void clearMoveKillList();
	
	/**
	 * Get the current {@link Color} turn 
	 */
	public Color getCurrColor();
}
