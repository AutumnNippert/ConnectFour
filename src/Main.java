public class Main {

    /**
     * Main Method for testing stuff.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(7, 6);
        Controller p1 = new Player(1);
        Controller p2 = new RandBot(2);
        Game g = new Game(b, p1, p2, 2);
        g.init();
    }
}
