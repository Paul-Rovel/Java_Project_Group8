package Entity;

import contract.Permeability;
import contract.Sprite;

/**
 * <h1>The Boulder Class.</h1>
 *
 * @author Paul-Kamga
 * @version 0.2
 */

public class Diamond extends Object {

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('2', "Diamond.png");
    private static String NAME = "Diamond";

    /**
     * Instantiates a new Diamond.
     */
    Diamond() {
        super(SPRITE, Permeability.BLOCKING);
        this.name = NAME;
    }
}
