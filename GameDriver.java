
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
        Player p1 = new Player("X", "Player 1");
        Player p2 = new Player("O", "Player 2");
        board.makeBoard();
        
        //Game Loop
        
        boolean on = true;
        
        while (on) {
            int col = p1.move();
            //check if column is full
            while (board.checkFull(col - 1)) {
                System.out.println("That column is full. Choose again. (1-7)");
                col = p1.move();
            }
            //check which row to put the piece
            board.checkColumn(6, col - 1, p1.symbol);
            //check if player 1 has won horizontally
            if (board.CheckXHorizontal() || board.CheckXVertical()) {
                board.printBoard();
                break;
            }
            else {
                board.printBoard();
            }
            
            int col2 = p2.move();
            while (board.checkFull(col2 - 1)) {
                System.out.println("That column is full. Choose again. (1-7)");
                col2 = p2.move();
            }
            board.checkColumn(6, col2 - 1, p2.symbol);
            if (board.CheckOHorizontal() || board.CheckOVertical() || board.CheckODiagonalLRLH()) {
                board.printBoard();
                break;
            }
            else {
                board.printBoard();
            }
        }
    }

}
