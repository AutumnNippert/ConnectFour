import java.util.ArrayList;

/**
 * RandBot Class.
 * Computer Controller.
 * Selects a valid random position and plays it.
 *
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public class VertBot extends Controller {

    VertBot(int playerNum) {
        super(playerNum);
    }

    @Override
    public void selectPosition(Board board) {
        //Gets playable options
        ArrayList<Integer> options = board.getPlayableOptions();
        //Selects one of the playable options
        this.selection = options.get(0);
        Utility.Debug.printDebug(false, Integer.toString(this.selection));
    }
}
