import java.util.ArrayList;
import java.util.Scanner;

/**
 * Menu Class.
 * Allows for easy menu creation output and input
 * @author Chris Nippert
 * @version 1.0
 */
public class Menu {
    public String value;
    public String name;
    public ArrayList< String > options;

    public Menu( String name, ArrayList< String > options ) {
        this.name = name;
        this.options = options;
    }

    /**
     * Displays the menu and all its contents.
     */
    public void display( ) {
        System.out.println( name );
        for ( int i = 1; i < this.options.size( ) + 1; i++ ) {
            System.out.println( "(" + i + ") " + this.options.get( i - 1 ) );
        }
        System.out.print( ">>> " );
        Scanner scn = new Scanner( System.in );
        this.value = scn.nextLine( );
    }

    /**
     * Gets the int value that was input
     * @return input value
     */
    public int getIntValue( ) {
        try {
            return Integer.parseInt( this.value );
        } catch ( Exception valueNotAnInteger ) {
            valueNotAnInteger.printStackTrace( );
            return -1;
        }
    }

    /**
     * Gets the string value that was input
     * @return input value
     */
    public String getStringValue( ) {
        return this.value;
    }
}