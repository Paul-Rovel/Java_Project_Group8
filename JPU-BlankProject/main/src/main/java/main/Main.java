package main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
    public static void main(final String[] args) throws Exception {
 Object[] levelchoice = {1, 2, 3, 4, 5};
		
		int level = (int)JOptionPane.showInputDialog(null, "Choose your level", "BoulderDash", JOptionPane.QUESTION_MESSAGE, null, levelchoice, levelchoice[0]);
	
		JOptionPane.showMessageDialog(null, "Vous avez choisi le niveau" + level, null, JOptionPane.INFORMATION_MESSAGE);
    	
        final IModel model = new Model("map"+level+".txt");
        final View view = new View(model.getLevel(), model.getRockford(), model.getLevel().getPawns());
        final IController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
        
    }
}
