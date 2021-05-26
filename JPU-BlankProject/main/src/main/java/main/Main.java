package main;

import java.sql.SQLException;
import controller.Controller;
import contract.IController;
import contract.IModel;
import model.Model;
import view.View;


/**
 * <h1>The Main Class.</h1>
 *
 * @author Paul-Kamga
 * @version 0.2
 */
public abstract class Main {


    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws Exception 
     */
    public static void main(final String[] args) throws Exception, SQLException {
 
    	
        final IModel model = new Model();
        final View view = new View(model.getLevel(), model.getRockford(), model.getLevel().getPawns());
        final IController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
        controller.play();
        
    }
}
