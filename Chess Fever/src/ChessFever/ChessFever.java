package ChessFever;

import java.awt.EventQueue;

import javax.swing.JFrame;

import view.MainFrame;

public class ChessFever {

	public static JFrame mainFrame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				mainFrame = new MainFrame();
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.setVisible(true);
				mainFrame.setLocationRelativeTo(null);
			}
		});
	}

}
