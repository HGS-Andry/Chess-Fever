package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Coordinates;
import model.Model;
import model.Piece;
import model.chessModel;
import ChessFever.ChessFever;
import ChessFever.properties;
import controller.Controller;
import controller.chessController;

public class gameFrame extends JFrame implements view.View {

	private static final long serialVersionUID = -3477430063014483640L;
	
	private int chessBoardSize=800;
	
	private Model gameModel;
	private Controller gameController;

	private JPanel piecesPlane;
	
	public gameFrame() {
		setTitle("Chess Fever - new Game");
		setSize(1280, 1024);
		
		//Initialize the Game
		gameModel= new chessModel();
		gameController=new chessController(gameModel,(View)this);
		
		//mainPanel
		JPanel mainPanel =new JPanel();
		mainPanel.setBackground(properties.bkColor);
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Player 1 panel TODO replace the label with player 1 panel
		JLabel player1Label=new JLabel("Player 1");
		player1Label.setPreferredSize(new Dimension(200,800));
		player1Label.setBackground(properties.textColor);
		c.weightx=0;
		c.weighty=1;
		c.gridx=0;
		mainPanel.add(player1Label,c);
		
		//chess board panel. A layered plane with a chess made of buttons and a glass plane were pieces are printed
		JLayeredPane layerdChessPlane =new JLayeredPane();
		layerdChessPlane.setSize(chessBoardSize, chessBoardSize);
		layerdChessPlane.setMinimumSize(layerdChessPlane.getSize());
		layerdChessPlane.setPreferredSize(layerdChessPlane.getSize());
		JPanel chessBoard= createChessBoard();
		piecesPlane = createPiecesPlane();
		c.weightx=1;
		c.weighty=1;
		c.gridx=1;
		layerdChessPlane.add(chessBoard,Integer.valueOf(1));
		layerdChessPlane.add(piecesPlane,Integer.valueOf(2));
		mainPanel.add(layerdChessPlane,c);

		//Player 2 panel TODO replace the label with player 2 panel
		JLabel player2Label=new JLabel("Player 2");
		player2Label.setPreferredSize(new Dimension(200,800));
		player2Label.setBackground(properties.textColor);
		c.weightx=0;
		c.weighty=1;
		c.gridx=2;
		mainPanel.add(player2Label,c);
		
		//Console Label
		
		add(mainPanel);
		
		repaint();
		
		//When close the window it set visible the main page
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing (java.awt.event.WindowEvent evt){
            	ChessFever.mainFrame.setVisible(true);
            }
		});
		
		
	}
	
	//Create a glass panel 
	private JPanel createPiecesPlane() {
		JPanel glass = new JPanel();
	    glass.setOpaque(false); // Set to true to see it
	    glass.setSize(chessBoardSize, chessBoardSize);
	    glass.setLocation(0, 0);	    
		return glass;
	}

	//Create a chess Board already initialized
	private JPanel createChessBoard() {
		JPanel chess=new JPanel();
		chess.setSize(chessBoardSize, chessBoardSize);
		chess.setMinimumSize(chess.getSize());
		chess.setPreferredSize(chess.getSize());
		chess.setLayout(null);
		for (int c=0; c<8;c++)
			for (int r = 0; r < 8; r++) {
				chessSquare test =new chessSquare((r+c)%2==0?model.Color.WHITE:model.Color.BLACK,r,c);
				test.setBounds((chessBoardSize/8)*c, (chessBoardSize/8)*r, chessBoardSize/8, chessBoardSize/8);
				test.addActionListener(action -> bottonePremuto(test));
				System.out.printf("Bottone %d,%d di colore %d creato\n",c,r,(r+c)%2==0?model.Color.WHITE.ordinal():model.Color.BLACK.ordinal()); //DEBUG 
				chess.add(test);
			}
		return chess;
	}
	
	

	private void bottonePremuto(chessSquare bottone) {
		System.out.printf("Bottone %d,%d premuto\n",bottone.getCoordinates().getXCCoordinate(),bottone.getCoordinates().getYRCoordinate());
	}

	@Override
	public Controller getController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void repaint(){	//TODO completa!
		//read information from the model
		Piece [][]chessBoard=gameModel.getConfiguration();
		int index;
		for (int r = 0; r < 8; r++)
			for (int c = 0; c < 8; c++) {
				index = getPieceIndex(chessBoard[r][c]);
				
			}
			
		
	}

	private int getPieceIndex(Piece piece) {
		int index=0;
		
		
		return index;
	}
}
