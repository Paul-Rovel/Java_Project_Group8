package model;

import java.util.Observable;
import java.io.IOException;

import contract.IActor;
import contract.ILevel;
import contract.IModel;
import Entity.Rockford;


/**
 * <h1>The Class Model.</h1>
 *
 * @author Paul-Kamga
 */
public final class Model extends Observable implements IModel {


    /** The Constant startX. */
    private static final int startX = 1;

    /** The Constant startY. */
    private static final int startY = 1;
    /** The road. */
    private ILevel   level;

    /** The my vehicle. */
    private IActor rockford;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param rockfordStartX
     *            the rockford start X
     * @param rockfordStartY
     *            the rockford start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Model(final String fileName)
            throws IOException {
        this.setLevel(new Level(fileName));
        this.setRockford(new Rockford(startX, startY, this.getLevel()));
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getRoad()
     */
    @Override
    public final ILevel getLevel() {
        return this.level;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the road to set
     */
    private void setLevel(final ILevel level) {
        this.level = level;
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getMyVehicle()
     */
    @Override
    public final IActor getRockford() {
        return this.rockford;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setRockford(final IActor rockford) {
        this.rockford = rockford;
    }	
	
	
}
