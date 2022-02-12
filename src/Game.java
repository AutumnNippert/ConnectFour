import java.awt.*;
import java.util.Arrays;

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
    private final int winConditionCount;

    private boolean isDebug = false;
    private boolean showGUIInProgress = false;

    public enum PlayerPiece{
        NONE, PLAYER_1, PLAYER_2
    }

    public Game(Board board, Controller c1, Controller c2, int winConditionCount) {
        this.board = board;
        this.c1 = c1;
        this.c2 = c2;
        this.winConditionCount = winConditionCount;
    }

    /**
     * Initializes the game
     */
    public void init(){
        int isGameOver = 0;
        Controller activeController = c1;
        while(true) {
            if (board.isFull()) break;
            isGameOver = isGameOver();
            if(isGameOver != 0) break;
            controllerPlay(activeController);
            //Utility.ConsoleFunctions.wait(500);
            if(activeController == c1) activeController = c2;
            else activeController = c1;
        }
        Utility.ConsoleFunctions.cls();
        System.out.println(board);

        if (board.isFull()) System.out.println("NO WINNER");
        else if(isGameOver == 1) System.out.println("PLAYER ONE WINS");
        else if (isGameOver == 2) System.out.println("PLAYER TWO WINS");
        Utility.MessagePrompts.gameOver();
    }

    private void controllerPlay(Controller c) {
        boolean isValidPlay = false;
        while(!isValidPlay){
            //Displaying board
            clearAndDisplayBoard();

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
        //Displaying board
        clearAndDisplayBoard();
    }

    /**
     * Checks to see if the game has ended
     * @return 0 if no player has one, 1 or 2 if controller 1 or controller 2 has won respectively
     */
    private int isGameOver(){
        Utility.Debug.printDebug(isDebug, "Checking isGameOver()");
        //Logic for if the game is over
        //incomplete yet

        Point[] winningPoints = new Point[winConditionCount];
        int[] maxes = new int[2];
        int[] currents = new int[2];
        int last = -1;

        //check for consecutivity horizontally
        //Definitely didn't steal this from the C code that we needed to make for 0p

        Utility.Debug.printDebug(isDebug, "Checking Horizontal Win");
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[0].length; j++) {
                int num = board.getBoard()[i][j];
                currents = detectCurrents(num, currents, last);
                maxes = detectMaxes(num, maxes, currents);
                //Controller 1 wins
                if(maxes[0] >= winConditionCount) {
                    for (int k = 0; k < winConditionCount; k++) {
                        winningPoints[k] = new Point(i, j - k);
                    }
                    for (Point p : winningPoints) {
                        board.setTrueCoord(p.x, p.y, 3);
                    }
                    return 1;
                }

                //Controller 2 wins
                if(maxes[1] >= winConditionCount) {
                    for (int k = 0; k < winConditionCount; k++) {
                        winningPoints[k] = new Point(i, j - k);
                    }
                    for (Point p : winningPoints) {
                        board.setTrueCoord(p.x, p.y, 4);
                    }
                    return 2;
                }
                last = num;
            }
            last = -1;
        }

        //check for consecutivity vertically
        //Definitely didn't steal this from the C code that we needed to make for 0p
        Utility.Debug.printDebug(isDebug, "Checking Vertical Win");
        for (int i = 0; i < board.getBoard()[0].length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                int num = board.getBoard()[j][i];
                currents = detectCurrents(num, currents, last);
                maxes = detectMaxes(num, maxes, currents);
                //Controller 1 wins
                if(maxes[0] >= winConditionCount) {
                    for (int k = 0; k < winConditionCount; k++) {
                        winningPoints[k] = new Point(j - k, i);
                    }
                    for (Point p : winningPoints) {
                        board.setTrueCoord(p.x, p.y, 3);
                    }
                    return 1;
                }

                //Controller 2 wins
                if(maxes[1] >= winConditionCount) {
                    for (int k = 0; k < winConditionCount; k++) {
                        winningPoints[k] = new Point(j - k, i);
                    }
                    for (Point p : winningPoints) {
                        board.setTrueCoord(p.x, p.y, 4);
                    }
                    return 2;
                }
                last = num;
            }
        }
        Utility.Debug.printDebug(isDebug, "Maxes: " + Arrays.toString(maxes));

        //If no winner yet
        return 0;
    }

    //returns curr = last
    boolean isConsecutive(int curr, int last){
        return curr == last;
    }

    int[] detectCurrents(int num, int[] currents, int last){

        if(num != 0) {
            Utility.Debug.printDebug(isDebug, "Current Number: " + num);
            Utility.Debug.printDebug(isDebug, "Last: " + last);
            Utility.Debug.printDebug(isDebug, "Is Consecutive: " + isConsecutive(num, last));
            if(isConsecutive(num, last)) {
                currents[num-1]++;
            } else {
                currents[num-1] = 1;
            }
        }
        return currents;
    }

    int[] detectMaxes(int num, int[] maxes, int[] currents){

        if(num != 0) {
            Utility.Debug.printDebug(isDebug, "\nCurrent =  " + currents[num-1]);
            Utility.Debug.printDebug(isDebug, "Max =  " + maxes[num-1]);
            Utility.Debug.printDebug(isDebug, "" + currents[num-1] + " > " + maxes[num-1] + ": " + (currents[num-1] > maxes[num-1]));
            if(currents[num-1] > maxes[num-1]){
                maxes[num-1] = currents[num-1];
            }
        }
        return maxes;
    }

    void clearAndDisplayBoard(){
        if(showGUIInProgress){
            Utility.ConsoleFunctions.cls();
            System.out.println(board);
        }
    }
}