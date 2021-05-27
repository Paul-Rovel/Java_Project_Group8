package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.exia.showboard.BoardFrame;
import contract.IView;
import contract.IActor;
import contract.IOrderPerformer;
import contract.ILevel;
import contract.ControllerOrder;

/**
 * <h1>The View Class.</h1>
 *
 * @author Paul-Kamga && Joseph
 * @version 0.4
 */

public class View implements Runnable, KeyListener, IView {


    /** The Constant levelView. */
    private static final int levelView   = 10;

    /** The Constant squareSize. */
    private static final int squareSize = 50;

    /** The Constant closeView. */
    private Rectangle closeView;

    /** The list of pawns. */
	@SuppressWarnings("unused")
	private ArrayList<IActor> pawns;
    
    /** The level. */
    private ILevel level;

    /** My vehicle. */
    private IActor rockford;

    /** The view. */
    private int view;

    /** The order performer. */
    private IOrderPerformer  orderPerformer;

	/** The BoardFrame. */
	private final BoardFrame boardFrame = new BoardFrame("Boulder Dash Group 8");

    /**
     * Instantiates a new boulder dash View.
     *
     * @param level
     *            the level
     * @param rockford
     *            the rockford
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws LineUnavailableException 
     * @throws UnsupportedAudioFileException 
     */
    public View(final ILevel level, final IActor rockford, final ArrayList<IActor> pawns) throws IOException {
    	super();
    	this.setView(levelView);
        this.setLevel(level);
        this.setRockford(rockford);
        this.getRockford().getSprite().loadImage();
        this.setPawns(pawns);
        this.setCloseView(new Rectangle(0, this.getRockford().getY(), this.getLevel().getWidth(), levelView));
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see contract.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
        boardFrame.setDimension(new Dimension(this.getLevel().getWidth(), this.getLevel().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getLevel().getWidth(); x++) {
            for (int y = 0; y < this.getLevel().getHeight(); y++) {
                boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getRockford());
        this.getLevel().getObservable().addObserver(boardFrame.getObserver());
        this.followRockford();

        boardFrame.setVisible(true);
    }

    /**
     * Prints the level and the player's vehicle in the console.
     *
     * @param yStart
     *            the y start
     */
    public final void show(final int yStart) {
        int y = yStart % this.getLevel().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getLevel().getWidth(); x++) {
                if ((x == this.getRockford().getX()) && (y == yStart)) {
                    System.out.print(this.getRockford().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getLevel().getOnTheLevelXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getLevel().getHeight();
            System.out.print("\n");
        }
    }

    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
     * @return the user order
     */
    private static ControllerOrder keyCodeToUserOrder(final int keyCode) {
        ControllerOrder userOrder;
        switch (keyCode) {
        	case KeyEvent.VK_RIGHT:
                userOrder = ControllerOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = ControllerOrder.LEFT;
                break;
            case KeyEvent.VK_UP:
                userOrder = ControllerOrder.UP;
                break;
            case KeyEvent.VK_DOWN:
                userOrder = ControllerOrder.DOWN;
                break;
           
            
            default:
                userOrder = ControllerOrder.NOP;
                break;
        }
        return userOrder;
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see contract.IView#followMyvehicle()
     */
    @Override
    public final void followRockford() {
			this.getCloseView().y = (int) (this.rockford.getY() - (this.getCloseView().getHeight() / 2));
			this.getCloseView().x = (int) (this.rockford.getX() - (this.getCloseView().getWidth() / 2));

			if (this.rockford.getY() < this.getCloseView().getHeight() / 2) {
				this.getCloseView().y = 0;
			} else if (this.rockford.getY() > (this.level.getHeight() - (this.getCloseView().getHeight() / 2))) {
				this.getCloseView().y = (int) (this.level.getHeight() - this.getCloseView().getHeight());
			}
			if (this.rockford.getX() < this.getCloseView().getWidth() / 2) {
				this.getCloseView().x = 0;
			} else if (this.rockford.getX() > (this.level.getWidth() - (this.getCloseView().getWidth() / 2))) {
				this.getCloseView().x = (int) (this.level.getWidth() - this.getCloseView().getWidth());
			}
		}

    /**
     * Gets the level.
     *
     * @return the level
     */
    public  ILevel getLevel() {
        return this.level;
    }

    /**
     * Sets the level.
     *
     * @param level
     *            the new level
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setLevel(final ILevel level) throws IOException {
        this.level = level;
        for (int x = 0; x < this.getLevel().getWidth(); x++) {
            for (int y = 0; y < this.getLevel().getHeight(); y++) {
                this.getLevel().getOnTheLevelXY(x, y).getSprite().loadImage();
            }
        }
    }

    /**
     * Gets Rockford.
     *
     * @return Rockford
     */
    private IActor getRockford() {
        return this.rockford;
    }

    /**
     * Sets Rockford.
     *
     * @param Rockford
     *            my new rockford
     */
    private void setRockford(final IActor rockford) {
        this.rockford = rockford;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private int getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final int view) {
        this.view = view;
    }

    /**
     * Gets the close view.
     *
     * @return the close view
     */
    private Rectangle getCloseView() {
        return this.closeView;
    }

    /**
     * Sets the close view.
     *
     * @param closeView
     *            the new close view
     */
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    /**
     * Gets the order performer.
     *
     * @return the order performer
     */
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    /**
     * Sets the order performer.
     *
     * @param orderPerformer
     *            the new order performer
     */
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
	
    /**
	 * Update the board frame and redraws squares.
	 */
	public void updateBoard() {
		for (int x = 0; x < this.getLevel().getWidth(); x++) {
			for (int y = 0; y < this.getLevel().getHeight(); y++) {
				
				boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
				
			}
		}
	}
	
	/**
	 * 
	 * @param newPawns
	 *            The pawn list.
	 */
	protected void setPawns(final ArrayList<IActor> newPawns) {
		this.pawns = newPawns;
	}
	
	/**
	 * @param step step to set
	 */
    
	public void drawDiamondcollected(int diamondscollected) {
        BoardFrame.setDiamondscollected(diamondscollected);
    }

	@Override
	public void drawStep(int step) {
		BoardFrame.setStep(step);
		
	}
	
}
