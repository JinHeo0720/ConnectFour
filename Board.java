
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
            //checks if space is empty
            board[r][c] = s;
        }
        
        else {
            checkColumn(r-1, c, s);
        }    

    }
        public boolean CheckXHorizontal(String s){
        //creates boolean to act as flag
        boolean win = false;
        //creates counter
        int counter = 0;
        //goes through board horizontally
        for(int w = 0; w < 7; w++){
            for(int h = 0; h < 7; h++){
                if(board[w][h].equals(s)){ //if it finds an X, add 1 to counter
                    counter++;
                }
                else{
                    counter = 0; // if next piece is not an X, set counter to 0
                }
                if(counter == 4){
                    System.out.println("You win"); //if counter is greater or equal to 4, player wins
                    win = true;
                }
            }
        }
        return win;
    }
}
