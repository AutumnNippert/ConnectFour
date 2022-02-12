import java.util.ArrayList;

/**
 * Board Class.
 * Only deals with the board itself.
 * @author Chris Nippert
 * @version 0 (unreleased)
 *
 * TO COMPILE IN CMD to \out\compiledCode
 * INSIDE THE \srd
 * javac .\Main.java -d .\..\out\compiledCode
 */
public class Board {

    private int[][] board;

    private final int width;
    private final int height;

    /**
     * This is the constructor for the Board.
     * This sets the initial variables, as well as creates an empty board of input size.
     * @param width width of board
     * @param height height of board
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        board = new int[height][width];
    }

    public int[][] getBoard() {
        return this.board;
    }

    /**
     * Gets the options available in the board to place a piece.
     *
     * @return arrayList of the x values that the controller is able to place a piece in (STARTING AT 1)
     */
    public ArrayList<Integer> getPlayableOptions() {
        ArrayList<Integer> positions = new ArrayList<>();

        //Checking the top most row for the existence of pieces
        for (int i = 0; i < this.board[0].length - 1; i++) {
            if (board[0][i] == 0) {
                positions.add(i + 1);
            }
        }
        return positions;
    }

    public void setCoord(int x, int y, int playerNum) {
        this.board[this.height - y - 1][x - 1] = playerNum;
    }

    /**
     * Sets the real coords of a location
     * @param x
     * @param y
     * @param playerNum
     */
    public void setTrueCoord(int x, int y, int playerNum) {
        this.board[x][y] = playerNum;
    }

    /**
     * This is done! DON'T TOUCH IT ITS VERY FRAGILE AND UGLY.
     *
     * @param x         input coord
     * @param playerNum player num
     */
    public void play(int x, int playerNum) {
        for (int i = 0; i < board.length; i++) {
            //If it's at the bottom or its at another number.
            //MY LORD THIS IS UGLY AF but my setCoord works upside down so I need to set the Y upside down as well.
            if (board[i][x - 1] != 0) {
                setCoord(x, board.length - i, playerNum);
                break;
            } else if (i == board.length - 1) {
                setCoord(x, board.length - 1 - i, playerNum);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String board = "";
        for (int[] arr : this.board) {
            for (int i : arr) {
                if (i == 0) { //WHITE IS NO PLAYER
                    Utility.ConsoleFunctions.printColorWithBackground("[ ]", Utility.Colors.BLACK, Utility.Colors.WHITE_BACKGROUND);
                } else if (i == 1) { //RED IS PLAYER 1
                    Utility.ConsoleFunctions.printColorWithBackground("[0]", Utility.Colors.BLACK, Utility.Colors.RED_BACKGROUND);
                } else if(i == 2) { //YELLOW IS PLAYER 2
                    Utility.ConsoleFunctions.printColorWithBackground("[0]", Utility.Colors.BLACK, Utility.Colors.YELLOW_BACKGROUND);
                } else if(i == 3) { //BLUE IS PLAYER 1 WINNING
                    Utility.ConsoleFunctions.printColorWithBackground("[0]", Utility.Colors.BLACK, Utility.Colors.BLUE_BACKGROUND);
                } else if(i == 4) { //GREEN IS PLAYER 2 WINNING
                    Utility.ConsoleFunctions.printColorWithBackground("[0]", Utility.Colors.BLACK, Utility.Colors.GREEN_BACKGROUND);
                }
            }
            System.out.println();
        }
        for (int i = 0; i < this.board[0].length; i++) {
            System.out.printf("%2d ", i+1);
        }
        System.out.println();
        return board;
    }
}
