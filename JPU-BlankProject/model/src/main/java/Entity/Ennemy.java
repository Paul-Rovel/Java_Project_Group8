package Entity;

import contract.Permeability;
import contract.Sprite;

/**
 * <h1>The Ennemy Class.</h1>
 *
 * @author Paul-Kamga
 * @version 0.2
 */

public class Ennemy extends Object {

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('5', "Ennemynop.png");
    private static String NAME = "Ennemy";

    /**
     * Instantiates a new Ennemy.
     */
    Ennemy() {
        super(SPRITE, Permeability.BLOCKING);
        this.name = NAME;
    }
	
}
