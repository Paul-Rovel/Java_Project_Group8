package contract;

import java.awt.Point;
import fr.exia.showboard.IPawn;


/**
 * <h1>The Interface IActor.</h1>
 *
 * @author Imelda
 * @version 0.1
 * @see IPawn
 * @see IElement
 */

public interface IActor extends IPawn, IElement {
    /**
     * Move up
     */
    void moveUp();

    /**
     * Move left
     */
    void moveLeft();

    /**
     * Move down
     */
    void moveDown();

    /**
     * Move right
     */
    void moveRight();

    /**
     * Do nothing
     */
    void doNothing();

    
    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    
    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    
    /**
     * Checks if Rockford is alive.
     *
     * @return the alive
     */
    Boolean isAlive();

    
    /**
     * Checks if the rockford is crushed.
     *
     * @return the boolean
     */
    Boolean isCrushed();
  

    
    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();
    
  
    
}
