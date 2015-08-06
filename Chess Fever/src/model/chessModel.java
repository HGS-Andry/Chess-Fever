package model;

import java.util.ArrayList;

public class chessModel implements Model {
	
	private Piece [][]  chessBoard;
	private ArrayList<Piece> blackDeadlist, whiteDeadlist;
	private ArrayList<Coordinates> moveCoord,killCoord;
	private Color currColor;
	private Piece currPiece;
	
	public chessModel() {
		initializeChessboard();
		currColor=Color.WHITE;
		currPiece=null;
		blackDeadlist=new ArrayList<>();
		whiteDeadlist=new ArrayList<>();
		moveCoord=new ArrayList<>();
		killCoord=new ArrayList<>();
	}
	
	private void initializeChessboard() {
		chessBoard=new Piece[8][8];
		Piece tmpPiece;
		Coordinates tmpCoordinates;
		for (int c = 0; c < 8; c++) {
			tmpCoordinates=new Coordinates(c, 1);
			tmpPiece=new Pawn(Color.BLACK, tmpCoordinates, this);
			chessBoard[c][1]=tmpPiece;
		}
		
		for (int c = 0; c < 8; c++) {
			tmpCoordinates=new Coordinates(c, 6);
			tmpPiece=new Pawn(Color.WHITE, tmpCoordinates, this);
			chessBoard[c][6]=tmpPiece;
		}
	}

	@Override
	public Piece[][] getConfiguration() {
		return chessBoard;
	}

	@Override
	public ArrayList<Piece> getBlackDeadlist() {
		return blackDeadlist;
	}

	@Override
	public ArrayList<Piece> getWhiteDeadlist() {
		return whiteDeadlist;
	}

	@Override
	public void move(Piece piece, Coordinates finalCoord) {
		//TODO da fare
	}

	@Override
	public void kill(Piece piece, Coordinates finalCoord) {
		//TODO da fare
		if (currColor==Color.WHITE) {
			
		}
		
	}

	@Override
	public Piece getPieceAt(Coordinates coordinate) {
		return chessBoard[coordinate.getYRCoordinate()][coordinate.getXCCoordinate()];
	}

	@Override
	public void setCurrPiece(Piece piece) {
		currPiece=piece;
		
	}

	@Override
	public Piece getCurrPiece() {
		return currPiece;
	}

	@Override
	public ArrayList<Coordinates> getMovesList() {
		return moveCoord;
	}

	@Override
	public ArrayList<Coordinates> getKillList() {
		return killCoord;
	}

	@Override
	public void setMovesList(ArrayList<Coordinates> coordList) {
		this.moveCoord=coordList;
	}

	@Override
	public void setKillList(ArrayList<Coordinates> coordList) {
		this.killCoord=coordList;	
	}

	@Override
	public Color getCurrColor() {
		return currColor;
	}

	@Override
	public void clearMoveKillList() {
		moveCoord.clear();
		killCoord.clear();
	}



}
