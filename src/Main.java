public class Main {

    /**
     * Main Method for testing stuff.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(20, 10);
        b.setCoord(2, 1, 1);
        b.setCoord(4, 6, 2);
        System.out.println(b);
    }
}
