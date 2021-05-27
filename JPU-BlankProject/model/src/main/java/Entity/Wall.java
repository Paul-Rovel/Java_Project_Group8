package Entity;

import contract.Permeability;
import contract.Sprite;

/**
 * <h1>The Wall Class.</h1>
 *
 * @author Joseph
 * @version 0.2
 */

public class Wall extends Object {

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('4', "Wall.png");
    private static String NAME = "Wall";

    /**
     * Instantiates a new Wall.
     */
    Wall() {
        super(SPRITE, Permeability.PENETRABLE);
        this.name = NAME;
    }
    
}
