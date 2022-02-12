import jdk.jshell.execution.Util;

import java.util.ArrayList;

/**
 * Player Class
 * Deals with the Player and its actions
 * Everything the Player class does is interact with what the player can see (like the board)
 * <p>
 * The player sees where to play, so methods like, selectPosition are here
 *
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public class Player extends Controller {

    private final int playerNum;
    private int selection;

    /**
     * Constructs Player.
     *
     * @param playerNum player number
     */
    public Player(int playerNum) {
        this.playerNum = playerNum;
    }

    @Override
    public void playPiece(Board board) {
        //Getting available options
        board.play(selection, playerNum);
    }

    @Override
    public void selectPosition(Board board) {
        //Creating the selection menu
        HorizontalMenu<String > selectionMenu = new HorizontalMenu<>("Selection Menu", new ArrayList<String>());
        //Displaying the menu
        selectionMenu.display();
        //Getting input
        this.selection = Integer.parseInt(selectionMenu.getInput(">>> "));
    }


}
