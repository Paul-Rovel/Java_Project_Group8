package contract;

import java.io.IOException;

/**
 * The Interface IView.
 *
 * @author Paul-Kamga
 * @version 0.1
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	  void displayMessage(String message);
	  
	  /**
	     * Follow Rockford.
	     */
	    void followRockford();
	    
	    /**
	     * Refreshes and redraws elements on the board
	     */
	    void updateBoard();

		void drawScore(String string);
		
		
}
