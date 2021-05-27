package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;

import contract.IActor;
import contract.IElement;
import contract.ILevel;
import Entity.Boulder;
import Entity.Diamond;
import Entity.Emptyspace;
import Entity.Ennemy;
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
     * Instantiates a new level with the content of the levelName.
     *
     * @param levelName
     *            the level name where the map of the level is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    Level() throws IOException {
        super();
Object[] levelchoice = {1, 2, 3, 4, 5, 6};
		
		int level = (int)JOptionPane.showInputDialog(null, "Choose your level", "BoulderDash", JOptionPane.QUESTION_MESSAGE, null, levelchoice, levelchoice[0]);
		
		JOptionPane.showMessageDialog(null, "Vous avez choisi le niveau" + level, null, JOptionPane.INFORMATION_MESSAGE);
        this.loadFile("src/map"+level+".txt");
    }

    /**
     * Loads level.
     *
     * @param levelName
     *            the level name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String levelName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(levelName)));
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
            	if (line.toCharArray()[x] == '0') {
                this.setOnTheLevelXY(ObjectFactory.createBoulder(), x, y);
                }
            	if (line.toCharArray()[x] == '1') {
                    this.setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y);
                    }
            	if (line.toCharArray()[x] == '2') {
                    this.setOnTheLevelXY(ObjectFactory.createDiamond(), x, y);
                    }
            	if (line.toCharArray()[x] == '3') {
                    this.setOnTheLevelXY(ObjectFactory.createGround(), x, y);
                    }
            	if (line.toCharArray()[x] == '4') {
                    this.setOnTheLevelXY(ObjectFactory.createWall(), x, y);
                    }
            	if (line.toCharArray()[x] == '5') {
                    this.setOnTheLevelXY(ObjectFactory.createEnnemy(), x, y);
                    }
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
     * @see fr.exia.insanevehicles.model.Ilevel#getHeight()
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
     * @see fr.exia.insanevehicles.model.Ilevel#getOnThelevelXY(int, int)
     */
    @Override
    public final IElement getOnTheLevelXY( int x,  int y) {
        return this.onTheLevel[x][y];
    }

    /**
     * Sets the on the level XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     * @return 
     */
    public void setOnTheLevelXY(final IElement element,  int x,  int y) {
         this.onTheLevel[x][y] = element;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.Ilevel#setMobileHasChanged()
     */
    @Override
    public final void setActorHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     * @see contract.ILevel#getObservable()
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

	
	/**
     * Make the objects fall.
     *
     * 
     */
	@Override
	public void elementsfall() throws IOException {

    	for(int x = 1; x < 16; x++){
    		
    		for(int y = 1; y <17 ; y++) {
    			
    			if(getOnTheLevelXY(x, y) instanceof Boulder) {//for each case in map[][] check if it is a Boulder 
    				
                  //  if(x==getRockford().getX() && y+1==getRockford().getY()){ 
                    //    }

                     if(getOnTheLevelXY(x,y+1) instanceof Emptyspace ) {// if the block under the Boulder is a Emptyspace
    					setOnTheLevelXY(ObjectFactory.createBoulder(), x, y+1); // create a Boulder under the Boulder
    					setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y); // create an Emptyspace on the old position of the Boulder

    				}
    				
                     else if(getOnTheLevelXY(x,y+1) instanceof Ennemy) {
                    	 setOnTheLevelXY(ObjectFactory.createBoulder(), x, y+1);
                    	 setOnTheLevelXY(ObjectFactory.createDiamond(), x, y);
                    	 setOnTheLevelXY(ObjectFactory.createDiamond(), x-1, y+1);
                    	 setOnTheLevelXY(ObjectFactory.createDiamond(), x+1, y+1);
                     }
    				
    				else if(getOnTheLevelXY(x,y+1) instanceof Boulder) {// if the element under the Boulder is a Boulder
		    				if(getOnTheLevelXY(x-1,y) instanceof Emptyspace) { // left side of Boulder empty
		    					if(getOnTheLevelXY(x-1,y+1) instanceof Emptyspace) {// check if left-under side of Boulder is Empty
		    						setOnTheLevelXY(ObjectFactory.createBoulder(), x-1, y+1); // create a Boulder left-under  the Boulder
		    						setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y); // create an Emptyspace on the old position of the Boulder

		    					}
		    				}
			    			else if(getOnTheLevelXY(x+1,y) instanceof Boulder) { // if the element at right of the boulder is a boulder
			    					if(getOnTheLevelXY(x+1,y+1) instanceof Emptyspace) {// check if right-down side  is free
			    						setOnTheLevelXY(ObjectFactory.createBoulder(), x+1, y+1); // create a Boulder right-under  the Boulder
			    						setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y); // create an Emptyspace on the old position of the Boulder
		
			    					}	
			    				} else {
			    					setOnTheLevelXY(ObjectFactory.createBoulder(), x, y);
			    			}
    				}
    				
    				
    			}
    			if(getOnTheLevelXY(x,y) instanceof Diamond) {//for each case in map[][] check if it is a diamond
    		//		 if(x==this.getRockford().getX() && y==this.getRockford().getY()){ 
              //          }
    				  if(getOnTheLevelXY(x,y+1) instanceof Emptyspace) {// if the element under the diamond is an Emptyspace
    					setOnTheLevelXY(ObjectFactory.createDiamond(), x, y+1); // create a diamond down the diamond
    					setOnTheLevelXY(ObjectFactory.createEmptyspace(), x, y); // create an emptyspace on the old position of the diamond
    					
    				}
    				}
    			if(getOnTheLevelXY(x,y) instanceof Wall) {
    				setOnTheLevelXY(ObjectFactory.createWall(), x, y);
    			}
    	        
    		}
    		
    	
    
    }
		
	}
}

