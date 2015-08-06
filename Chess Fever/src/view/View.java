package view;

import controller.*;

public interface View {
	/**
	 * Get the used Controller
	 */
	public Controller getController();
	
	/**
	 * Apply modifications
	 */
	public void repaint();
	
}
