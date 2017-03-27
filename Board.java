
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
        
        //prints blank board after setup
        for (int row = 0; row < 7; row++) {            
            for (int col = 0; col < 7; col++) {                
                System.out.print("|" + board[row][col] + "|");
            }
            System.out.println();
        }
    }
    
    public void printBoard() {
        //prints board during play
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {               
                System.out.print("|" + board[row][col] + "|");
            }
            System.out.println();
        }
    }
    
    //Checks where to put a piece
    public void checkColumn(int r, int c, String s) {  
        if (checkFull(c) == false) {
            if (board[r][c].equals("_")) { 
                //checks if space is empty and sets the element to the piece (X or O)
                board[r][c] = s;
            }
            
            else {
                //recursive call but this time one row higher
                checkColumn(r-1, c, s);
            }    
        }

    }
    
    //Checks if a column is full
    public boolean checkFull(int c) {               
        if (board[0][c].equals("X") || board[0][c].equals("O")) { 
            //checks if the top space is occupied
            return true;
        }   
        else {
            return false;
        }
    }
    
    //Checks for cat's game
    public boolean catsGame() {
        int counter = 0;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (board[r][c].equals("X") || board[r][c].equals("O")) {
                    counter++;
                }
            }
        }
        
        if (counter == 49) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    
    //CHECKING FOR WIN
    
    //Checks if a player 1 has won horizontally
    public boolean checkXHorizontal(){
        //creates boolean to act as flag
        boolean win = false;
        //creates counter
        int counter = 0;
        //goes through board horizontally
        for(int r = 0; r < 7; r++){
            for(int c = 0; c < 7; c++){
                if (board[r][c].equals("X")) { //if it finds the symbol, add 1 to counter
                    counter++;
                }
                else {
                    counter = 0; //if next piece is not an X, set counter to 0
                }
                if (counter == 4) {
                    System.out.println("Player 1 wins!"); //if counter is greater or equal to 4, player wins
                    win = true;
                }
            }
        }
        return win;
    }
    
    //Checks if player 1 has won vertically
    public boolean checkXVertical(){
        //creates boolean to act as flag
        boolean win = false;
        //creates counter
        int counter = 0;
        //goes through board horizontally
        for(int c = 0; c < 7; c++){
            for(int r = 0; r < 7; r++){
                if (board[r][c].equals("X")) { //if it finds the symbol, add 1 to counter
                    counter++;
                }
                else {
                    counter = 0; //if next piece is not an X, set counter to 0
                }
                if (counter == 4) {
                    System.out.println("Player 1 wins!"); //if counter is greater or equal to 4, player wins
                    win = true;
                }
            }
        }
        return win;
    }
    
    //Checks if player 2 has won vertically
    public boolean checkOVertical(){
        //creates boolean to act as flag
        boolean win = false;
        //creates counter
        int counter = 0;
        //goes through board horizontally
        for(int c = 0; c < 7; c++){
            for(int r = 0; r < 7; r++){
                if (board[r][c].equals("O")) { //if it finds the symbol, add 1 to counter
                    counter++;
                }
                else {
                    counter = 0; //if next piece is not an X, set counter to 0
                }
                if (counter == 4) {
                    System.out.println("Player 2 wins!"); //if counter is greater or equal to 4, player wins
                    win = true;
                }
            }
        }
        return win;
    }
    
    //Checks if player 1 has won with a diagonal from left right, low high
    public boolean checkXDiagonalLR(){
        //creates boolean to act as flag
        boolean win = false;
        boolean getOut = false;
        
        //goes through board horizontally
        for(int c = 0; c < 4; c++){
            for(int r = 6; r > 2; r--){
                if (board[r][c].equals("X") && board[r-1][c+1].equals("X") && board[r-2][c+2].equals("X")
                && board[r-3][c+3].equals("X")) { //if it finds the symbol, add 1 to counter
                    System.out.println("Player 1 wins!");
                    getOut = true;
                    win = true;
                }
                else {
                    win = false; //if next piece is not an X, set counter to 0
                }

            }
        }
        
        if (getOut) {
            win = true;
        }
        return win;
    }
    
    //Checks if player 1 has won with a diagonal from right to left, low high
    public boolean checkXDiagonalRL(){
        //creates boolean to act as flag
        boolean win = false;
        boolean getOut = false;
        
        //goes through board horizontally
        for(int c = 6; c > 2; c--){
            for(int r = 6; r > 2; r--){
                if (board[r][c].equals("X") && board[r-1][c-1].equals("X") && board[r-2][c-2].equals("X")
                && board[r-3][c-3].equals("X")) { //if it finds the symbol, add 1 to counter
                    System.out.println("Player 1 wins!");
                    getOut = true;
                }
                else {
                    win = false; //if next piece is not an X, set counter to 0
                }

            }
        }
        
        if (getOut) {
            win = true;
        }
        return win;
    }
    
    //checks player 1's diagonals collectively
    public boolean checkXDiagonals() {
        if (checkXDiagonalRL() || checkXDiagonalLR()) {
            return true;
        }
        else
            return false;
    }

    //checks if player 2 has won horizontally
    public boolean checkOHorizontal(){
        //creates boolean to act as flag
        boolean win = false;
        //creates counter
        int counter = 0;
        //goes through board horizontally
        for(int r = 0; r < 7; r++){
            for(int c = 0; c < 7; c++){
                if (board[r][c].equals("O")) { //if it finds the symbol, add 1 to counter
                    counter++;
                }
                else {
                    counter = 0; //if next piece is not an X, set counter to 0
                }
                if (counter == 4) {
                    System.out.println("Player 2 wins!"); //if counter is greater or equal to 4, player wins
                    win = true;
                }
            }
        }
        return win;
    }
    
    //Checks if player 2 has won with a diagonal from left right, low high
    public boolean checkODiagonalLR(){
        //creates boolean to act as flag
        boolean win = false;
        boolean getOut = false;
        //goes through board horizontally
        for(int c = 0; c < 4; c++){
            for(int r = 6; r > 2; r--){
                if (board[r][c].equals("O") && board[r-1][c+1].equals("O") && board[r-2][c+2].equals("O")
                && board[r-3][c+3].equals("O")) { //if it finds the symbol, add 1 to counter
                    System.out.println("Player 2 wins!");
                    getOut = true;
                    win = true;
                }
                else {
                    win = false; //if next piece is not an X, set counter to 0
                }

            }
        }
        
        if (getOut) {
            win = true;
        }
        return win;
    }
    
    //Checks if player 2 has won with a diagonal from right to left, low high
    public boolean checkODiagonalRL(){
        //creates boolean to act as flag
        boolean win = false;
        boolean getOut = false;
        //goes through board horizontally
        for(int c = 6; c > 2; c--){
            for(int r = 6; r > 2; r--){
                if (board[r][c].equals("O") && board[r-1][c-1].equals("O") && board[r-2][c-2].equals("O")
                && board[r-3][c-3].equals("O")) { //if it finds the symbol, add 1 to counter
                    System.out.println("Player 2 wins!");
                    getOut = true;
                    win = true;
                }
                else {
                    win = false; //if next piece is not an X, set counter to 0
                }

            }
        }
        
        if (getOut) {
            win = true;
        }
        return win;
    }
    
    
    //checks player 2's diagonals collectively
    public boolean checkODiagonals() {
        if (checkODiagonalRL() || checkODiagonalLR()) {
            return true;
        }
        else
            return false;
    }
}

