package Entity;

import contract.Permeability;
import contract.Sprite;
import contract.ILevel;

public class Object extends Element {

    /**
     * Instantiates a new object.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    Object(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }

    public boolean fall(boolean fall) {
		if (fall = true) {getLevel().getOnTheLevelXY(setX(getX()), setY(getY()+1));}
    	return fall;
    	
    }
 
}
