package ChessFever;

import javax.swing.JFrame;

import controller.Controller;
import view.View;

public class gameFrame extends JFrame implements View {

	public gameFrame() {
		setTitle("Play!!");
		setSize(805, 600);
		
		//When close the window it set visible the main page
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing (java.awt.event.WindowEvent evt){
            	ChessFever.mainFrame.setVisible(true);
            }
		});
		
		
	}
	
	@Override
	public Controller getController() {
		// TODO Auto-generated method stub
		return null;
	}

}
