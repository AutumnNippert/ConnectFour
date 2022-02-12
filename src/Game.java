import jdk.jshell.execution.Util;

/**
 * Game Class
 * Deals with all the game functionality
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public class Game {
    private final Board board;
    private final Controller c1;
    private final Controller c2;

    public enum PlayerPiece{
        NONE, PLAYER_1, PLAYER_2
    }

    public Game(Board board, Controller c1, Controller c2) {
        this.board = board;
        this.c1 = c1;
        this.c2 = c2;
    }

    public void init(){
        while(true) {
            if(isGameOver()) break;
            controllerPlay(c1);
            if(isGameOver()) break;
            controllerPlay(c2);
        }
    }

    private void controllerPlay(Controller c) {
        boolean isValidPlay = false;
        while(!isValidPlay){
            //Displaying board
            Utility.ConsoleFunctions.cls();
            System.out.println(board);
            //Getting input
            try {
                c.selectPosition(board);
                try{
                    c.playPiece(board);
                    isValidPlay = true;
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    Utility.MessagePrompts.invalidSelection();
                }
            } catch (Exception e) {
                Utility.MessagePrompts.invalidNumber();
            }

        }
    }

    private boolean isGameOver(){
        //Logic for if the game is over
        //incomplete yet
        return false;
    }
}