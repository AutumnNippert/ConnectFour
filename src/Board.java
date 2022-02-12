/**
 * Board Class.
 * Only deals with the board itself.
 * @author Chris Nippert
 * @version 0 (unreleased)
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
    public Board(int width, int height){
        this.width = width;
        this.height = height;
        board = new int[height][width];
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setCoord(int x, int y, int playerNum) {
        this.board[this.height - y][x-1] = playerNum;
    }

    @Override
    public String toString() {
        String board = "";
        for (int[] arr : this.board ) {
            for (int i : arr ) {
                if(i == 0) { //WHITE IS NO PLAYER
                    Utility.ConsoleFunctions.printColor("[ ]", Utility.Colors.WHITE_BACKGROUND);
                } else if(i == 1) { //RED IS PLAYER 1
                    Utility.ConsoleFunctions.printColor("[ ]", Utility.Colors.RED_BACKGROUND);
                } else if(i == 2) { //YELLOW IS PLAYER 2
                    Utility.ConsoleFunctions.printColor("[ ]", Utility.Colors.YELLOW_BACKGROUND);
                }
            }
            System.out.println();
        }
        return board;
    }
}
