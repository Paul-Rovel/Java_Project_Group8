package Entity;

import contract.Permeability;
import contract.Sprite;

/**
 * <h1>The Emptyspace Class.</h1>
 *
 * @author Joseph
 * @version 0.2
 */

public class Emptyspace extends Object {

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('1', "Emptyspace.png");
    private static String NAME = "Emptyspace";

    /**
     * Instantiates a new Emptyspace.
     */
    Emptyspace() {
        super(SPRITE, Permeability.PENETRABLE);
        this.name = NAME;
    }
	
}
