package model;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;

import contract.IActor;
import contract.IElement;
import contract.ILevel;
import Entity.Boulder;
import Entity.Diamond;
import Entity.Emptyspace;
import Entity.ObjectFactory;
import Entity.Wall;

public class Level extends Observable implements ILevel {


    /** The width. */
    public int width;

    /** The height. */
    public int height;

    /** The on the level. */
    private IElement[][] onTheLevel;
    
    /** The pawn list */
	  private ArrayList<IActor> pawns;

    /**
     * Instantiates a new level with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the level is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    Level(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }

    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheLevelXY(ObjectFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }

    /*
     * (non-Javadoc)
     * @see contract.ILevel#getWidth()
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getHeight()
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
     */
    @Override
    public final IElement getOnTheLevelXY(final int x, final int y) {
        return this.onTheLevel[x][y];
    }

    /**
     * Sets the on the road XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     * @return 
     */
    public void setOnTheLevelXY(final IElement element, final int x, final int y) {
         this.onTheLevel[x][y] = element;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#setMobileHasChanged()
     */
    @Override
    public final void setActorHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getObservable()
     */
    @Override
    public Observable getObservable() {
        return this;
    }

	@Override
	public void addPawn(IActor pawn) {
		this.pawns.add(pawn);
		
	
	}

	@Override
	public ArrayList<IActor> getPawns() {
		 return this.pawns;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setScore(int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDiamondCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDiamondCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getAddScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IActor getRockford() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNbDiamond() {
		// TODO Auto-generated method stub
		return 0;
	}
	
public void rockfall() throws IOException {	
    	
    	for(int x = 1; x < 16; x++){
    		
    		for(int y = 1; y < 17 ; y++) {
    			
    			if(onTheLevel[x][y] instanceof Boulder) {//for each case in map[][] check if it is a Boulder 
    				if(onTheLevel[x][y+1] instanceof Emptyspace ) {// if the block under the Boulder is a Emptyspace
    					setOnTheLevelXY(ObjectFactory.createBoulder(), x, y+1); // create a Boulder under the Boulder
    					setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y); // create an Emptyspace on the old position of the Boulder
    					
    				}
    				else if(onTheLevel[x][y+1] instanceof Boulder) {// if the element under the Boulder is a Boulder
		    				if(onTheLevel[x-1][y] instanceof Emptyspace) { // left side of Boulder empty
		    					if(onTheLevel[x-1][y+1] instanceof Emptyspace) {// check if left-under side of Boulder is Empty
		    						setOnTheLevelXY(ObjectFactory.createBoulder(), x-1, y+1); // create a Boulder left-under  the Boulder
		        					setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y); // create an Emptyspace on the old position of the Boulder

		    					}
		    				}
			    			else if(onTheLevel[x+1][y] instanceof Boulder) { // if the element at right of the boulder is a boulder
			    					if(onTheLevel[x+1][y+1] instanceof Emptyspace) {// check if right-down side  is free
			    						setOnTheLevelXY(ObjectFactory.createBoulder(), x+1, y+1); // create a Boulder right-under  the Boulder
			        					setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y); // create an Emptyspace on the old position of the Boulder
		
			    					}	
			    				} else {
			    					setOnTheLevelXY(ObjectFactory.createBoulder(), x, y);
			    			}
    				}
    			}
    			if(onTheLevel[x][y] instanceof Diamond) {//for each case in map[][] check if it is a diamond
    				if(onTheLevel[x][y+1] instanceof Emptyspace) {// if the element under the diamond is an Emptyspace
    					setOnTheLevelXY(ObjectFactory.createDiamond(), x, y+1); // create a diamond down the diamond
    					setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y); // create an emptyspace on the old position of the diamond
    					
    				}
    				}
    			if(onTheLevel[x][y] instanceof Wall) {
    				setOnTheLevelXY(ObjectFactory.createWall(), x, y);
    			}
    	        
    		}
    		
    	}
    
    }
    
}

