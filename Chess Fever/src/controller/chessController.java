package controller;

import java.util.ArrayList;

import javax.swing.text.View;

import model.Coordinates;
import model.Model;
import model.Piece;

public class chessController implements Controller {
	private Model gameModel;
	private view.View gameView;
	//private ArrayList<Coordinates> moveCoord,killCoord; //TODO elimina
	
	public chessController(Model gameModel,view.View gameView) {
		this.gameModel=gameModel;
		this.gameView=gameView;
	}
	@Override
	public void pressed(Coordinates coordinate) {
		Piece currPiece=gameModel.getCurrPiece();
		Piece tmpPiece;
		//If there is no selected piece
		if (currPiece==null){
			tmpPiece=gameModel.getPieceAt(coordinate);
			if(tmpPiece!=null && tmpPiece.getColor()==gameModel.getCurrColor()){		//If the chosen square is occupied by a piece of the current color select it
				tmpPiece.calculateMoves();
				tmpPiece.calculateKills();
				gameView.repaint();
			}
		}else{								//If a piece is already selected
			tmpPiece=gameModel.getPieceAt(coordinate);
			if(tmpPiece==null)
				gameModel.clearMoveKillList();
				gameView.repaint();
		}
		/*
		if(currPiece!=null){
			moveCoord=currPiece.getMoves();
			killCoord=currPiece.getKills();
		}
		else{
			currPiece=gameModel.getPieceAt(coordinate);
			if(currPiece!=null){
				
			}
		}
			if(currPiece=)
		else{
			gameModel.setCurrPiece(null);
			moveCoord.clear();
			killCoord.clear();
		}
		*/
	}
	

}
