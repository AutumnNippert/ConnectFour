import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utility {

    public static class Colors {
        //COLORS
        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

        //BACKGROUND COLORS
        public static final String BLACK_BACKGROUND = "\u001B[40m";
        public static final String RED_BACKGROUND = "\u001B[41m";
        public static final String GREEN_BACKGROUND = "\u001B[42m";
        public static final String YELLOW_BACKGROUND = "\u001B[43m";
        public static final String BLUE_BACKGROUND = "\u001B[44m";
        public static final String PURPLE_BACKGROUND = "\u001B[45m";
        public static final String CYAN_BACKGROUND = "\u001B[46m";
        public static final String WHITE_BACKGROUND = "\u001B[47m";
    }

    public static class MessagePrompts {

        public static void invalidSelection( ) {
            Scanner scn = new Scanner( System.in );
            System.out.println( "Invalid selection" );
            System.out.print( "Press 'Enter' to continue..." );
            scn.nextLine( );
        }

        public static void invalidNumber( ) {
            Scanner scn = new Scanner( System.in );
            System.out.println( "Invalid number" );
            System.out.print( "Press 'Enter' to continue..." );
            scn.nextLine( );
        }

        public static void gameOver( ) {
            System.out.println( """
                      _____                         ____                 
                     / ____|                       / __ \\                
                    | |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ 
                    | | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__|
                    | |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |   
                     \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   
                                                """
            );
        }
    }

    /**
     * Console Functions class
     * Used for manipulating things within the console
     */
    public static class ConsoleFunctions {
        public static void cls() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        /**
         * Waits for milliseconds
         * @param milliseconds amount of time to wait
         */
        public static void wait(int milliseconds) {
            try {
                TimeUnit.MILLISECONDS.sleep(milliseconds);
            } catch (Exception e) {
                System.out.println("wait failed");
            }
        }

        /**
         * Waits for the return key to be pressed.
         */
        public static void waitForInput() {
            Scanner scn = new Scanner(System.in);
            System.out.print( "Press 'Enter' to continue..." );
            scn.nextLine();
        }

        /**
         * Prints an input string with a specific color as well as adding a new line.
         * @param s input string
         * @param c input color
         */
        public static void printlnColor(String s, String c){
            System.out.println(c + s + Colors.RESET);
        }

        /**
         * Prints an input string with a specific color.
         * @param s input string
         * @param c input color
         */
        public static void printColor(String s, String c){
            System.out.print(c + s + Colors.RESET);
        }

        /**
         * Prints an input string with a specific color.
         * @param s input string
         * @param cFore input foreground color
         * @param cBack input background color
         */
        public static void printColorWithBackground(String s, String cFore, String cBack){
            System.out.print(cBack + cFore + s + Colors.RESET);
        }
    }

    /**
     * Debug Class
     * Only used for debug
     */
    public static class Debug{
        /**
         * Prints ONLY IF debug is true.
         * @param isDebug isDebug
         * @param str string
         */
        public static  void printDebug( boolean isDebug, String str ) {
            if ( isDebug ) System.out.println( str );
        }
        /*public static <T> void printDebug( boolean isDebug, T str ) {
            if ( isDebug ) System.out.println( str );
        }*/

        public static void wait(boolean isDebug, int milliseconds) {
            if (isDebug) {
                try {
                    TimeUnit.MILLISECONDS.sleep(milliseconds);
                } catch (Exception e) {
                    System.out.println("debug wait failed");
                }
            }
        }
    }

    /**
     * Generates a random number between min and max (inclusive)
     * @param min min value of Random
     * @param max max value of random
     * @return random number
     */
    public static int randInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
