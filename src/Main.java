public class Main {

    /**
     * Main Method for testing stuff.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(200, 200);
        //Controller c1 = new Player(1);
        Controller c1 = new RandBot(1);
        Controller c2 = new RandBot(2);
        Game g = new Game(b, c1, c2, 15);
        g.init();
    }
}
