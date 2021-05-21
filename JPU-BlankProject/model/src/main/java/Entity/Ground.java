package Entity;

import contract.Permeability;
import contract.Sprite;

/**
 * <h1>The Boulder Class.</h1>
 *
 * @author Paul-Kamga
 * @version 0.2
 */

public class Ground extends Object {

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('3', "Ground.png");
    private static String NAME = "Ground";

    /**
     * Instantiates a new Ground.
     */
    Ground() {
        super(SPRITE, Permeability.BLOCKING);
        this.name = NAME;
    }
}
