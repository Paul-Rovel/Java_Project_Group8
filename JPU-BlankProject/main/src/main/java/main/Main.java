package main;

import java.io.IOException;

import contract.IController;
import contract.IModel;
import controller.Controller;
import model.Model;
import view.View;

/**
 * <h1>The Main Class.</h1>
 *
 * @author Paul-Kamga
 * @version 0.2
 */
public abstract class Main {

    /** The Constant startX. */
    private static final int startX = 5;

    /** The Constant startY. */
    private static final int startY = 0;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InterruptedException
     *             the interrupted exception
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final IModel model = new Model("level1.txt", startX, startY);
        final View view = new View(model.getLevel(), model.getRockford(), model.getLevel().getPawns());
        final IController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
        
    }
}
