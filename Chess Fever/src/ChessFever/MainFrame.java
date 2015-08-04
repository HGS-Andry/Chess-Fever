package ChessFever;

import java.awt.BorderLayout;

import javax.swing.*;
/**
 * Main page of the game, it contains the play button
 * @author Andrea Dall'Alba
 *
 */

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame(){
		setTitle("Chess Fever");
		setResizable(false);
		setSize(805, 600); 
		//setIconImage(new ImageIcon("img/puzzle15.jpg").getImage());  TODO Inserire immagine icona
		
		//Frame description
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(properties.bkColor);
		
		//Title
		JLabel titleImage = new JLabel("Title");
		titleImage.setIcon(new ImageIcon("Images/Title.png"));
		titleImage.setLayout( new BorderLayout() );
		titleImage.setBounds(100, 50, 600, 400);
		mainPanel.add(titleImage);
		
		//Play Button
		JButton playButton = new JButton("PLAY!");
		playButton.addActionListener(event -> newGame());
		playButton.setBounds(400-70, 500-30, 140, 60);
		playButton.setBackground(properties.textColor);
		playButton.setForeground(properties.titleColor);
		playButton.setFont(properties.bigFont);
		playButton.setFocusPainted(false);
		mainPanel.add(playButton);
		add(mainPanel);
	}

	private void newGame() {
		// TODO Auto-generated method stub
		System.out.println("Do you wanna play? no! LOL!");
		JFrame gameFrame = new gameFrame();
		gameFrame.setVisible(true);
		ChessFever.mainFrame.setVisible(false);
	}
}
