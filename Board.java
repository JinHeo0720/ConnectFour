
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    // instance variables - replace the example below with your own
    String[][] board = new String[7][7];

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {

    }

    public void makeBoard() {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = "_";
            }
        }
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("|" + board[row][col] + "|");
            }
            System.out.println();
        }
    }
    
    public void printBoard() {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("|" + board[row][col] + "|");
            }
            System.out.println();
        }
    }
    
    public void checkColumn(int r, int c, String s) {        
        
        if (board[r][c].equals("_")) {
            board[r][c] = s;
        }
        
        else {
            checkColumn(r-1, c, s);
        }    
        
       
       
       
    }
}
