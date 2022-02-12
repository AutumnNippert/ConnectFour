public class Main {

    /**
     * Main Method for testing stuff.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(7, 6);
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Game g = new Game(b, p1, p2);
        g.init();
    }
}
