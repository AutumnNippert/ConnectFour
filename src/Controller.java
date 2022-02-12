/**
 * Abstract Controller Class.
 * It can't exist on its own, but it can have sub-classes that can, like Player and AI.
 * This class defines some generic things that Players and AI have in common.
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public abstract class Controller {

    /**
     * The controller plays a piece.
     * @param board the board that the controller is on
     */
    public abstract void playPiece(Board board);

    public abstract void selectPosition(Board board);
}
