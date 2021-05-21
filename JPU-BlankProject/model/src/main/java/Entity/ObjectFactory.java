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


    /**
     * The object is an array of all possible objects.
     */
    private static Object[]     object  = {boulder, diamond, emptyspace, ground, wall,};

    /**
     * Creates a new object.
     *
     * @return the object
     */
    public static Object createBoulder() {
        return boulder;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Object createDiamond() {
        return diamond;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Object createEmptyspace() {
        return emptyspace;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Object createGround() {
        return ground;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Object createWall() {
        return wall;
    }
    

    /**
     * Gets the good object from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static Object getFromFileSymbol(final char fileSymbol) {
        for (final Object object : object) {
            if (object.getSprite().getConsoleImage() == fileSymbol) {
                return object;
            }
        }
        return emptyspace;
    }


	
}
