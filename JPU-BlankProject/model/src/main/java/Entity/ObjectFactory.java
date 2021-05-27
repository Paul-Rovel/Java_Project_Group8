package Entity;

/**
 * <h1> A factory to create objects.</h1>
 *
 * @author Paul-Kamga
 * @version 0.3
 */

public class ObjectFactory {

    /** The Constant boulder. */
    private static final Boulder boulder = new Boulder();

    /** The Constant diamond. */
    private static final Diamond diamond = new Diamond();

    /** The Constant emptyspace. */
    private static final Emptyspace emptyspace = new Emptyspace();

    /** The Constant wall. */
    private static final Wall  wall  = new Wall();

    /** The Constant ground. */
    private static final Ground  ground  = new Ground();
    
    /** The Constant ennemy. */
    private static final Ennemy ennemy = new Ennemy();


    /**
     * The object is an array of all possible objects.
     */
    private static Object[]     object  = {boulder, diamond, emptyspace, ground, wall, ennemy,};

    /**
     * Creates a new object.
     *
     * @return the object
     */
    public static Object createBoulder() {
        return boulder;
    }

    /**
     * Creates a new object.
     *
     * @return the object
     */
    public static Object createDiamond() {
        return diamond;
    }

    /**
     * Creates a new object.
     *
     * @return the object
     */
    public static Object createEmptyspace() {
        return emptyspace;
    }

    /**
     * Creates a new object.
     *
     * @return the object
     */
    public static Object createGround() {
        return ground;
    }

    /**
     * Creates a new object.
     *
     * @return the object
     */
    public static Object createWall() {
        return wall;
    }
    
    /**
     * Creates a new object.
     *
     * @return the object
     */
    public static Object createEnnemy() {
        return ennemy;
    }

    /**
     * Gets the good object from level symbol.
     *
     * @param levelName
     *            the level name
     * @return the from level symbol
     */
    public static Object getFromFileSymbol(final char levelSymbol) {
        for (final Object object : object) {
            if (object.getSprite().getConsoleImage() == levelSymbol) {
                return object;
            }
        }
        return emptyspace;
    }


	
}
