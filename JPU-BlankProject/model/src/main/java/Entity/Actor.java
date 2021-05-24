package Entity;

import java.awt.Point;
import java.io.IOException;

import fr.exia.showboard.IBoard;
import contract.IActor;
import contract.ILevel;
import contract.Permeability;
import contract.Sprite;
import Entity.ObjectFactory;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Paul-Kamga
 * @version 0.3
 */

public class Actor extends Element implements IActor {

    /**
     * The x and The y.
     */
    private Point position;

    /** The alive. */
    private Boolean alive = true;

    /** The road. */
    private ILevel   level;

    /** The board. */
    private IBoard  board;

    /**
     * Instantiates a new Actor.
     *
     * @param sprite
     *            the sprite
     * @param road
     *            the level
     * @param permeability
     *            the permeability
     */
    Actor(final Sprite sprite, final ILevel level, final Permeability permeability) {
        super(sprite, permeability);
        this.setLevel(level);
        this.position = new Point();
    }

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Actor(final int x, final int y, final Sprite sprite, final ILevel level, final Permeability permeability) {
        this(sprite, level, permeability);
        this.setX(x);
        this.setY(y);
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#moveUp()
     */
    
   /* public void moveUp() { 
    	if (this.getY() > 0) {
    		if (this.getLevel().getOnTheLevelXY(getX(), getY()-1) instanceof Wall) {System.out.println("00000");
        this.setY(this.getY() - 1);
        this.setHasMoved();
    		}
    		getOnTheLevelXY(getX(), getY()-1);
    		
    		this.getLevel().setOnTheLevelXY(ObjectFactory.createEmptyspace(), this.getY(), this.getX());
        }
    }*/
    @Override
    public void moveUp() { 
    	if (this.getY() > 0) {
    		if (this.getLevel().getOnTheLevelXY(getX(), getY()-1) instanceof Wall ){this.setY((this.getY()));	
    		System.out.println("en bas d'un mur, rockford ne peut pas monter!");
    		}
    		else if ( this.getLevel().getOnTheLevelXY(getX(), getY()-1) instanceof Boulder ){this.setY((this.getY()));
    		System.out.println("en bas d'un rocher, rockford ne peut pas monter!");
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX(), getY()-1) instanceof Diamond ) {this.setY(this.getY()-1);
    		System.out.println("en bas d'un diamant, rockford peut monter!");
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX(), getY()-1) instanceof Ground ) {this.setY(this.getY()-1);
    		System.out.println("en bas d'un ground, rockford peut monter!");
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX(), getY()-1) instanceof Emptyspace ) {
    	this.setY(this.getY()-1);
    		}
        this.setHasMoved();	
    	}
    	
        }
    

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#moveLeft()
     */
    @Override
    public void moveLeft() {
    	if (this.getX() > 0) {
        /*this.setX(this.getX() - 1);
        this.setHasMoved();*/
    		if (this.getLevel().getOnTheLevelXY(getX()-1, getY()) instanceof Wall ){this.setY((this.getY()));	//if there is a wall no move
    		System.out.println("à droite d'un mur, rockford ne peut pas aller à gauche!");
    		}
    		else if ( this.getLevel().getOnTheLevelXY(getX()-1, getY()) instanceof Boulder ){	//check if there is a boulder
    			if ( this.getLevel().getOnTheLevelXY(getX()-2, getY()) instanceof Boulder || this.getLevel().getOnTheLevelXY(getX()-1, getY()) instanceof Diamond || this.getLevel().getOnTheLevelXY(getX()-1, getY()) instanceof Ground ) { //if there is an object after the boulder no move
    				this.setX((this.getX())); 
    				System.out.println("rockford ne peut pas aller a gauche car il ya un objet apres ce rocher!");
    			}
    			else { //if there is an emptyspace after the boulder
    				this.getLevel().setOnTheLevelXY(ObjectFactory.createEmptyspace(), this.getX()-1, this.getY());
    				this.getLevel().setOnTheLevelXY(ObjectFactory.createBoulder(), this.getX()-2, this.getY());
    				this.setX((this.getX()-1));
    				System.out.println("à droite d'un rocher, rockford ne peut pas aller à gauche en remplacant le rocher!");
    				}
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX()-1, getY()) instanceof Diamond ) {this.setX(this.getX()-1);
    		System.out.println("à droite d'un diamant, rockford peut aller à gauche!");
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX()-1, getY()) instanceof Ground ) {this.setX(this.getX()-1);
    		System.out.println("à droite d'un ground, rockford peut aller à gauche!");
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX()-1, getY()) instanceof Emptyspace ) {
    		this.setX(this.getX()-1);
    		}
        this.setHasMoved();
        }
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#moveDown()
     */
    @Override
    public void moveDown() {
    	if (this.getY() < 9) {
    		if (this.getLevel().getOnTheLevelXY(getX(), getY()+1) instanceof Wall || this.getLevel().getOnTheLevelXY(getX(), getY()+1) instanceof Boulder ){this.setY((this.getY()));	
    		System.out.println("en haut dun mur ou d'un rocher, rockford ne peut pas descendre!");
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX(), getY()+1) instanceof Diamond ) {this.setY(this.getY()+1);
    		System.out.println("en haut d'un diamant, rockford peut descendre!");
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX(), getY()+1) instanceof Ground ) {this.setY(this.getY()+1);
    		System.out.println("en haut d'un ground, rockford peut descendre!");
    		}
    		else if (this.getLevel().getOnTheLevelXY(getX(), getY()+1) instanceof Emptyspace ) {
    	this.setY(this.getY()+1);
    		}
        this.setHasMoved();	
        }
    }

    /*
     * (non-Javadoc)
     * @see  model.element.Actor.IActor#moveRight()
     */
    @Override
    public void moveRight() {
    		if (this.getX() < this.getLevel().getWidth()-1) {
    	    		if (this.getLevel().getOnTheLevelXY(getX()+1, getY()) instanceof Wall ){this.setY((this.getY()));	//if there is a wall no move
    	    		System.out.println("à droite d'un mur, rockford ne peut pas aller à gauche!");
    	    		}
    	    		else if ( this.getLevel().getOnTheLevelXY(getX()+1, getY()) instanceof Boulder ){	//check if there is a boulder
    	    			if ( this.getLevel().getOnTheLevelXY(getX()+2, getY()) instanceof Boulder || this.getLevel().getOnTheLevelXY(getX()+2, getY()) instanceof Diamond || this.getLevel().getOnTheLevelXY(getX()+2, getY()) instanceof Ground ) { //if there is an object after the boulder no move
    	    				this.setX((this.getX())); 
    	    				System.out.println("rockford ne peut pas aller a gauche car il ya un objet apres ce rocher!");
    	    			}
    	    			else { //if there is an emptyspace after the boulder
    	    				this.getLevel().setOnTheLevelXY(ObjectFactory.createEmptyspace(), this.getX()+1, this.getY());
    	    				this.getLevel().setOnTheLevelXY(ObjectFactory.createBoulder(), this.getX()+2, this.getY());
    	    				this.setX((this.getX()+1)); 
    	    				System.out.println("à droite d'un rocher, rockford ne peut pas aller à gauche en remplacant le rocher!");
    	    				}
    	    		}
    	    		else if (this.getLevel().getOnTheLevelXY(getX()+1, getY()) instanceof Diamond ) {this.setX(this.getX()+1);
    	    		System.out.println("à droite d'un diamant, rockford peut aller à gauche!");
    	    		}
    	    		else if (this.getLevel().getOnTheLevelXY(getX()+1, getY()) instanceof Ground ) {this.setX(this.getX()+1);
    	    		System.out.println("à droite d'un ground, rockford peut aller à gauche!");
    	    		}
    	    		else if (this.getLevel().getOnTheLevelXY(getX()+1, getY()) instanceof Emptyspace ) {
    	    		this.setX(this.getX()+1);
    	    		}
    	        this.setHasMoved();
        }
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#doNothing()
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the actor has moved.
     */
    private void setHasMoved() {
        this.getLevel().setActorHasChanged();
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#getX()
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
 
    public final void setX(final int x) {
    	 this.getPosition().x = x;
        if (this.isCrushed()) {
            this.die();
        }
       
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the road height.
     */
    public final void setY(final int y) {
        this.getPosition().y = (y + this.getLevel().getHeight()) % this.getLevel().getHeight();
        if (this.isCrushed()) {
            this.die();
        }
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public ILevel getLevel() {
        return this.level;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setLevel(final ILevel level) {
        this.level = level;
    }

    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor.IMobile#isAlive()
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isCrashed()
     */
    @Override
    public Boolean isCrushed() {
        return this.getLevel().getOnTheLevelXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    /*
     * (non-Javadoc)
     * @see model.element.Actor.IActor#getPosition()
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }
   
    public void digDirt() {
		this.getLevel().setOnTheLevelXY(ObjectFactory.createEmptyspace(), this.getY(), this.getX());
		try {
			this.getLevel().getOnTheLevelXY(getX(), getY()).getSprite().loadImage();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}
