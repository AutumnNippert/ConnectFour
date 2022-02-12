/**
 * Game Class
 * Deals with all the game functionality
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public class Game {
    private final Board board;
    private final Controller p1;
    private final Controller p2;

    public enum PlayerPiece{
        NONE, PLAYER_1, PLAYER_2
    }

    public Game(Board board, Controller p1, Controller p2) {
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
    }
}
