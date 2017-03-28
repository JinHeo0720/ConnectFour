
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Player9
{
    // instance variables - replace the example below with your own
    private int column;
    Scanner scan = new Scanner(System.in);
    public String symbol;
    public String name;
    
    public Player9(String sym, String nombre) {
        this.symbol = sym;
        this.name = nombre;
    }
    
    public int move() {
        System.out.println(name + ": " + "Select a column (1-7)");
        column = scan.nextInt();
        
        //makes sure entry is within bounds of columns
        while (column > 9 || column < 1) {
            System.out.println("That column is out of bounds. Choose again. (1-7)");
            column = scan.nextInt();
        }
        
        return column;        
    }
    
    

}