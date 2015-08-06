package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ChessFever.ChessFever;
import ChessFever.properties;
import controller.Controller;

public class gameFrame extends JFrame implements View {

	private static final long serialVersionUID = -3477430063014483640L;
	
	private int chessBoardSize=800;

	public gameFrame() {
		setTitle("Chess Fever - new Game");
		setSize(1280, 1024);
		
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
		
		//chess board panel
		JPanel chessBoard= createChessBoard();
		c.weightx=1;
		c.weighty=1;
		c.gridx=1;
		mainPanel.add(chessBoard,c);

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
		
		//When close the window it set visible the main page
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing (java.awt.event.WindowEvent evt){
            	ChessFever.mainFrame.setVisible(true);
            }
		});
		
		
	}
	
	//Create a chess Board already initialized
	private JPanel createChessBoard() {
		// TODO
		JPanel chess=new JPanel();
		chess.setSize(chessBoardSize, chessBoardSize);
		chess.setMinimumSize(chess.getSize());
		chess.setPreferredSize(chess.getSize());
		chess.setLayout(null);
		int c,r;
		
		//TODO migliorare la scelta del colore (r+c)pari=bianco, altrimenti nero!

		for (c=0; c<8;c++)
			for (r = 0; r < 8; r++) {
				chessSquare test =new chessSquare((r+c)%2==0?model.Color.WHITE:model.Color.BLACK,r,c);
				test.setBounds((chessBoardSize/8)*c, (chessBoardSize/8)*r, chessBoardSize/8, chessBoardSize/8);
				test.addActionListener(action -> bottonePremuto(test));
				System.out.printf("Bottone %d,%d di colore %d creato\n",c,r,(r+c)%2==0?model.Color.WHITE.ordinal():model.Color.BLACK.ordinal());
	
				chess.add(test);
			}
		return chess;
	}
	
	

	private void bottonePremuto(chessSquare bottone) {
		System.out.printf("Bottone %d,%d di premuto\n",bottone.r,bottone.c);
	}

	@Override
	public Controller getController() {
		// TODO Auto-generated method stub
		return null;
	}

}
