package Entity;

import java.io.IOException;

import contract.ILevel;
import contract.Permeability;
import contract.Sprite;

public class Rockford extends Actor {

    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite('H', "Rockfordnop.png");

    /** The Constant lookLeft. */
    private static final Sprite spritemoveLeft = new Sprite('H', "Rockfordleft.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spritemoveRight = new Sprite('H', "Rockfordright.png");

    /** The Constant spriteTurnUp. */
    private static final Sprite spritemoveUp = new Sprite('H', "Rockfordup.png");
    
    /** The Constant spriteTurnDown. */
    private static final Sprite spritemoveDown = new Sprite('H', "Rockforddown.png");
    
    /** The Constant spriteExplode. */
    private static final Sprite spriteDie   = new Sprite('H', "Rockforddie.png");

    /**
     * Instantiates a new rockford.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param road
     *            the level
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Rockford(final int x, final int y, final ILevel level) throws IOException {
        super(x, y, sprite, level, Permeability.BLOCKING);
        spritemoveLeft.loadImage();
        spritemoveRight.loadImage();
        spritemoveUp.loadImage();
        spritemoveDown.loadImage();
        spriteDie.loadImage();
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spritemoveLeft);
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spritemoveRight);
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#moveLeft()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spritemoveUp);
    }
    
    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#moveLeft()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spritemoveDown);
    }
    
    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }

	public static void setImgObject(Object object) {
		// TODO Auto-generated method stub
		
	}

	public static java.lang.Object getImgObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public static java.lang.Object getIconObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void setIconObject(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}
