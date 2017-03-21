
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
    public static void main(String[]args)
    {
        Board board = new Board();
        Player p1 = new Player("X");
        Player p2 = new Player("O");
        board.makeBoard();
        
        //Game Loop
        
        boolean won = false;
        
        while (won == false) {
            int col = p1.move();
            board.checkColumn(6, col - 1, p1.symbol);
            won = board.CheckXHorizontal(p1.symbol);
            board.printBoard();
            if (won = true) {
                break;
            }
            int col2 = p2.move();
            board.checkColumn(6, col2 - 1, p2.symbol);
            won = board.CheckXHorizontal(p2.symbol);
            board.printBoard();
            if (won = true) {
                break;
            }
        }
    }

}
