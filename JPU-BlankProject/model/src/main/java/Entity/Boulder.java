package Entity;

import contract.Permeability;
import contract.Sprite;

/**
 * <h1>The Boulder Class.</h1>
 *
 * @author Paul-Kamga
 * @version 0.2
 */

public class Boulder extends Object {

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('0', "Boulder.png");
    private static String NAME = "Boulder";

    /**
     * Instantiates a new Boulder.
     */
    Boulder() {
        super(SPRITE, Permeability.BLOCKING);
        this.name = NAME;
    }
	
}
