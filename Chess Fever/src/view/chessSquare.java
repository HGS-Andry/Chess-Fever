package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import ChessFever.properties;
import model.Coordinates;

public class chessSquare extends JComponent implements MouseListener {

	private static final long serialVersionUID = -5944937482184311753L;
	
	private boolean mouseEntered =false;; 	
	private model.Color color;
	private Coordinates squareCoordinate;
	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();
	public chessSquare(model.Color color,int r, int c){
		super();
		this.color=color;
		squareCoordinate= new Coordinates(r,c);
		enableInputMethods(true);   
		addMouseListener(this);
	}
	
	/**
	 * Return the {@link Coordinates} of the square
	 * @return
	 */
	public Coordinates getCoordinates(){
		return squareCoordinate;
	}
	
	//Method to paint the component
	@Override
	 public void paintComponent(Graphics graphics)
	  {
		Image squareImage = new ImageIcon(properties.squareImagePath).getImage();
		Graphics2D paintGraphics = (Graphics2D) graphics;
		paintGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		paintGraphics.drawImage(squareImage, 0, 0, this.getWidth(), this.getHeight(),color.ordinal()*256,0,color.ordinal()*256+256,256, null); //TODO controlla ordinal...
		//Empathize the selected square
		if(mouseEntered){
			paintGraphics.setColor(new Color(0x56FFB400,true));//TODO rifare il colore
			paintGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
	  }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseEntered =true;
		repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseEntered =false;
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		notifyListeners(e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//Methods to use events
    public void addActionListener(ActionListener listener)
    {
        listeners.add(listener);
    }
    
    private void notifyListeners(MouseEvent e)
    {
        ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, new String(), e.getWhen(), e.getModifiers());
        synchronized(listeners)
        {
            for (int i = 0; i < listeners.size(); i++)
            {
                ActionListener tmp = listeners.get(i);
                tmp.actionPerformed(evt);
            }
        }
    }
	
	
}
