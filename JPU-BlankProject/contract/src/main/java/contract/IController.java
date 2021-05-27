package contract;

import java.io.IOException;

/**
 * The Interface IController.
 *
 * @author Joseph
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();
	  /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
	 * @throws Exception 
     */
    void play() throws InterruptedException, Exception;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 * @throws IOException 
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws IOException;
}
