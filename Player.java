
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Player extends Board
{
    // instance variables - replace the example below with your own
    private int column;
    private int moveCount = 0;
    Scanner scan = new Scanner(System.in);
    public String symbol;
    
    public Player(String sym) {
        this.symbol = sym;
    }
    
    public int move() {
        System.out.println("Select a column (1-7)");
        column = scan.nextInt();
        return column;        
    }
    
    

}
