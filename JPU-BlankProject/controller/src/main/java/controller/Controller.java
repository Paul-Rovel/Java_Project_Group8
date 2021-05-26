package controller;

import java.io.IOException;

import Entity.Actor;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.IOrderPerformer;
import contract.ControllerOrder;
import model.DBConnection;

/**
 * <h1>The Class InsaneVehiclesController.</h1>
 *
 * @author Paul-Kamga
 * @version 0.1
 * @see IOrderPerformer
 */
public final class Controller implements IController, IOrderPerformer {

    /** The Constant speed. */
    private static final int     speed = 150;

    /** The view. */
    private IView  view;

    /** The model. */
    private IModel model;

    /** The stack order. */
    private ControllerOrder stackOrder;
    
    private DBConnection dao;

    /**
     * Instantiates a new insane vehicles controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public Controller(final IView view, final IModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
        this.dao = new DBConnection();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#play()
     */
    @Override
    public final void play() throws InterruptedException, Exception {
        while (this.getModel().getRockford().isAlive()) {
        	 this.getModel().getLevel().elementsfall();
        	
            Thread.sleep(speed);
         this.getView().updateBoard();
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getRockford().moveRight();
                    break;
                case LEFT:
                    this.getModel().getRockford().moveLeft();
                    break;
                case UP:
                    this.getModel().getRockford().moveUp();
                    break;
                case DOWN:
                    this.getModel().getRockford().moveDown();
                    break;
                case NOP:
                	 this.getModel().getRockford().doNothing();
                     break;
                default:
                    break;
            }
            this.clearStackOrder();
            this.getView().updateBoard();
            	if(Actor.diamondnumber > 9 ) {
            	this.getView().displayMessage("!!!!!!!!! YOU WON !!!!!!!!!.");
            	}
            	else {
            		
            	}
            this.getView().followRockford();
            }
        
        
        this.getView().displayMessage("!!!!!!!!! YOU DIED !!!!!!!!!.");
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IOrderPerformed#orderPerform(fr.exia.insanevehicles.
     * controller.UserOrder)
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#orderPerform(fr.exia.
     * insanevehicles.controller.UserOrder)
     */
    @Override
    public final void orderPerform(final ControllerOrder controllerOrder) throws IOException {
        this.setStackOrder(controllerOrder);
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private IView getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IView view) {
        this.view = view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    private IModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private ControllerOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final ControllerOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = ControllerOrder.NOP;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#getOrderPeformer()
     */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

	@Override
	public void control() {
		// TODO Auto-generated method stub
		
	}

	
    
	
   
}
