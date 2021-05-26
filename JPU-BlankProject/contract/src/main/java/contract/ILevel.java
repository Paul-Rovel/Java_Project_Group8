package contract;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * <h1>The Interface ILevel.</h1>
 *
 * @author Paul-Kamga
 * @version 0.1
 */

public interface ILevel {
	
    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the level XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the level XY
     */

	/**
     * @return int
     */
    int getScore();

    /**
     * @param score
     */
    void setScore(int score);


    public IElement getOnTheLevelXY(int x, int y);
    
    /**
     * Sets the on the level XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    void setOnTheLevelXY(final IElement element, final int x, final int y);

    /** Increments the diamond count */
	public void addDiamondCount();

	/**
	 * Get DiamondCount
	 * 
	 * @return DiamondCount, number of diamond in the map.
	 */
	public int getDiamondCount();

	void getAddScore();
	
	/** @return The rockford */
	public IActor getRockford();
	
	int getNbDiamond();
	
    /**
     * Sets that the Actor has changed.
     */
    void setActorHasChanged();

    public void addPawn(final IActor pawn);
    
	/** @return The pawns on the current map */
	public ArrayList<IActor> getPawns();
	
    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();
    
    public void elementsfall() throws IOException;
	
}
