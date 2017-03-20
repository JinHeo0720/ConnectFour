
/**
 * Write a description of class GameDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameDriver 
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class GameDriver
     */
    public void main(String[]args)
    {
        Board board = new Board();
        Player p1 = new Player("X");
        Player p2 = new Player("O");
        board.makeBoard();
        
        //Game Loop
        
        int col = p1.move();
        board.checkColumn(6, col, p1.symbol);
        board.printBoard();
        int col2 = p2.move();
        board.checkColumn(6, col2, p2.symbol);
        board.printBoard();
    }

}
