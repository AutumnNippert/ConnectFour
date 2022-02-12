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

    Player(int controllerNum) {
        super(controllerNum);
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
