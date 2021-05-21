package Entity;

import contract.Permeability;
import contract.Sprite;

/**
 * <h1>The Boulder Class.</h1>
 *
 * @author Paul-Kamga
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
