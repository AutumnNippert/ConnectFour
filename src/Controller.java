/**
 * Abstract Controller Class.
 * It can't exist on its own, but it can have sub-classes that can, like Player and AI.
 * This class defines some generic things that Players and AI have in common.
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public abstract class Controller {

    protected final int controllerNum;
    protected int selection;

    /**
     * Constructs the controller.
     *
     * @param controllerNum controller number
     */
    public Controller(int controllerNum) {
        this.controllerNum = controllerNum;
    }

    /**
     * The controller plays a piece.
     * @param board the board that the controller is on
     */
    public void playPiece(Board board) {
        board.play(selection, controllerNum);
    }

    public abstract void selectPosition(Board board);
}
