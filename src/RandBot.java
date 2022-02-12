import java.util.ArrayList;

/**
 * TrashBot Class
 * Computer Controller
 *
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public class RandBot extends Controller {

    private final int playerNum;
    private int selection;

    /**
     * Constructs Player.
     *
     * @param playerNum player number
     */
    public RandBot(int playerNum) {
        this.playerNum = playerNum;
    }

    @Override
    public void playPiece(Board board) {
        //Getting available options
        board.play(selection, playerNum);
    }

    @Override
    public void selectPosition(Board board) {
        //Gets playable options
        ArrayList<Integer> options = board.getPlayableOptions();
        //Selects one of the playable options
        selection = options.get(Utility.randInt(0, options.size()-1));
    }
}
