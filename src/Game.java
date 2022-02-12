import jdk.jshell.execution.Util;

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

    public enum PlayerPiece{
        NONE, PLAYER_1, PLAYER_2
    }

    public Game(Board board, Controller c1, Controller c2, int winConditionCount) {
        this.board = board;
        this.c1 = c1;
        this.c2 = c2;
        this.winConditionCount = winConditionCount;
    }

    public void init(){
        while(true) {
            if(isGameOver() != 0) break;
            controllerPlay(c1);
            Utility.ConsoleFunctions.wait(500);
            if(isGameOver() != 0) break;
            controllerPlay(c2);
        }
        if(isGameOver() == 1){
            System.out.println("PLAYER ONE WINS");
        } else if (isGameOver() == 2) {
            System.out.println("PLAYER TWO WINS");
        }
        Utility.MessagePrompts.gameOver();
    }

    private void controllerPlay(Controller c) {
        boolean isValidPlay = false;
        //Displaying board
        Utility.ConsoleFunctions.cls();
        System.out.println(board);
        while(!isValidPlay){
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
            //Displaying board
            Utility.ConsoleFunctions.cls();
            System.out.println(board);

        }
    }

    /**
     * Checks to see if the game has ended
     * @return 0 if no player has one, 1 or 2 if controller 1 or controller 2 has won respectively
     */
    private int isGameOver(){
        //Logic for if the game is over
        //incomplete yet
        int[] currents = new int[]{0, 0};
        int[] maxes = new int[]{0, 0};

        int last = -1;

        //check for consecutivity horizontally
        //Definitely didn't steal this from the C code that we needed to make for 0p
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[0].length; j++) {

                int num = board.getBoard()[i][j];
                Utility.Debug.printDebug(isDebug, "Current Number: " + num);

                if(num != 0) {
                    Utility.Debug.printDebug(isDebug, "Last: " + last);
                    Utility.Debug.printDebug(isDebug, "Is Consecutive: " + isConsecutive(num, last));
                    if(isConsecutive(num, last)) {
                        currents[num-1]++;
                    } else {
                        currents[num-1] = 1;
                    }
                    Utility.Debug.printDebug(isDebug, "\nCurrent =  " + currents[num-1]);
                    Utility.Debug.printDebug(isDebug, "Max =  " + maxes[num-1]);
                    Utility.Debug.printDebug(isDebug, "" + currents[num-1] + " > " + maxes[num-1] + ": " + (currents[num-1] > maxes[num-1]));
                    if(currents[num-1] > maxes[num-1]){
                        maxes[num-1] = currents[num-1];
                    }
                }
                last = num;
            }
        }

        //check for consecutivity vertically
        //Definitely didn't steal this from the C code that we needed to make for 0p
        for (int i = 0; i < board.getBoard()[0].length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {

                int num = board.getBoard()[j][i];
                Utility.Debug.printDebug(isDebug, "Current Number: " + num);

                if(num != 0) {
                    Utility.Debug.printDebug(isDebug, "Last: " + last);
                    Utility.Debug.printDebug(isDebug, "Is Consecutive: " + isConsecutive(num, last));
                    if(isConsecutive(num, last)) {
                        currents[num-1]++;
                    } else {
                        currents[num-1] = 1;
                    }
                    Utility.Debug.printDebug(isDebug, "\nCurrent =  " + currents[num-1]);
                    Utility.Debug.printDebug(isDebug, "Max =  " + maxes[num-1]);
                    Utility.Debug.printDebug(isDebug, "" + currents[num-1] + " > " + maxes[num-1] + ": " + (currents[num-1] > maxes[num-1]));
                    if(currents[num-1] > maxes[num-1]){
                        maxes[num-1] = currents[num-1];
                    }
                }
                last = num;
            }
        }
        Utility.Debug.printDebug(isDebug, "Maxes: " + Arrays.toString(maxes));

        //Controller 1 wins
        if(maxes[0] >= winConditionCount) return 1;

        //Controller 2 wins
        if(maxes[1] >= winConditionCount) return 2;

        //If no winner yet
        return 0;
    }

    //returns curr = last
    boolean isConsecutive(int curr, int last){
        return curr == last;
    }
}