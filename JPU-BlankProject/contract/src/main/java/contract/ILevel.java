package contract;

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
    IElement getOnTheLevelXY(int x, int y);
    
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

    /**
     * Sets the Actor has changed.
     */
    void setActorHasChanged();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();
	
}
