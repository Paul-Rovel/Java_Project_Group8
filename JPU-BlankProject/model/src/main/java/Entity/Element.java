package Entity;

import java.awt.Image;

import fr.exia.showboard.ISquare;
import contract.IElement;
import contract.Permeability;
import contract.Sprite;


/**
 * <h1>The Element Class.</h1>
 *
 * @author Paul-Kamga
 * @version 0.4
 * @see ISquare
 */

public class Element implements IElement {

    /** The sprite. */
    private Sprite sprite;

    /** The permeability. */
    private Permeability permeability;
    
    protected String name;

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }

    /*
     * (non-Javadoc)
     * @see model.Element#getSprite()
     */
    @Override
    public final Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite
     *            the new sprite
     */
    protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.IElement#getPermeability()
     */
    @Override
    public final Permeability getPermeability() {
        return this.permeability;
    }

    /**
     * Sets the permeability.
     *
     * @param permeability
     *            the new permeability
     */
    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.IElement#getImage()
     */
    @Override
    public final Image getImage() {
        return this.getSprite().getImage();
    }
    
	public String getName() {
		return name;
	}
}
