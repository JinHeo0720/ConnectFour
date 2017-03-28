
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board9
{
    // instance variables - replace the example below with your own
    String[][] board = new String[9][9];

    /**
     * Constructor for objects of class Board
     */
    public Board9()
    {
        
    }
    
    //creates the board
    public void makeBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col] = "_";
            }
        }
        
        //prints blank board after setup
        for (int row = 0; row < 9; row++) {            
            for (int col = 0; col < 9; col++) {                
                System.out.print("|" + board[row][col] + "|");
            }
            System.out.println();
        }
    }
    
    //prints the board
    public void printBoard() {
        //prints board during play
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {               
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
        for (int c = 0; c < 9; c++) {
            if (checkFull(c)) {
                counter++;
            }
        }
        
        if (counter == 9) {
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
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if (board[r][c].equals("X")) { //if it finds the symbol, add 1 to counter
                    counter++;
                }
                else {
                    counter = 0; //if next piece is not an X, set counter to 0
                }
                if (counter >= 4) {
                    System.out.println("Player 1 wins!"); //if counter is greater or equal to 4, player 1 wins
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
        for(int c = 0; c < 9; c++){
            for(int r = 0; r < 9; r++){
                if (board[r][c].equals("X")) { //if it finds the symbol, add 1 to counter
                    counter++;
                }
                else {
                    counter = 0; //if next piece is not an X, set counter to 0
                }
                if (counter >= 4) {
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
        for(int c = 0; c < 9; c++){
            for(int r = 0; r < 9; r++){
                if (board[r][c].equals("O")) { //if it finds the symbol, add 1 to counter
                    counter++;
                }
                else {
                    counter = 0; //if next piece is not an O, set counter to 0
                }
                if (counter >= 4) {
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
        //creates boolean to get out of for loop
        boolean getOut = false;
        
        //goes through first 3 columns and last 4 rows
        for(int c = 0; c < 6; c++){
            for(int r = 8; r > 2; r--){
                if (board[r][c].equals("X") && board[r-1][c+1].equals("X") && board[r-2][c+2].equals("X")
                && board[r-3][c+3].equals("X")) { //if it finds X in a diagonal pattern, get out boolean is triggered
                    System.out.println("Player 1 wins!");
                    getOut = true;
                }
                else {
                    win = false; //if the pattern is not completed, win is false
                }

            }
        }
        
        //if win is set to true within the for loop, it may be overwritten when the loop checks the other sections of the board so getOut remains true if just one diagonal is found
        if (getOut) {
            win = true;
        }
        return win;
    }
    
    //Checks if player 1 has won with a diagonal from right to left, low high
    public boolean checkXDiagonalRL(){
        //creates boolean to act as flag
        boolean win = false;
        //creates boolean to get out of for loop
        boolean getOut = false;
        
        //goes through last 3 columns and last 4 rows
        for(int c = 8; c > 2; c--){
            for(int r = 8; r > 2; r--){
                if (board[r][c].equals("X") && board[r-1][c-1].equals("X") && board[r-2][c-2].equals("X")
                && board[r-3][c-3].equals("X")) { //if it finds X in a diagonal pattern, get out boolean is triggered
                    System.out.println("Player 1 wins!");
                    getOut = true;
                }
                else {
                    win = false; //if the pattern is not completed, win is false
                }

            }
        }
        
        //if win is set to true within the for loop, it may be overwritten when the loop checks the other sections of the board so getOut remains true if just one diagonal is found
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
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
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
        //creates boolean to get out of for loop
        boolean getOut = false;
        
        //checks first 5 columns, last 4 rows
        for(int c = 0; c < 6; c++){
            for(int r = 8; r > 2; r--){
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
        //creates boolean to get out of for loop
        boolean getOut = false;
        
        //goes through last 5 columns and last 4 rows
        for(int c = 8; c > 2; c--){
            for(int r = 8; r > 2; r--){
                if (board[r][c].equals("O") && board[r-1][c-1].equals("O") && board[r-2][c-2].equals("O")
                && board[r-3][c-3].equals("O")) { //if it finds O in a diagonal pattern, get out boolean is triggered
                    System.out.println("Player 2 wins!");
                    getOut = true;
                    win = true;
                }
                else {
                    win = false; //if the pattern is not completed, win is false
                }

            }
        }
        
        //if win is set to true within the for loop, it may be overwritten when the loop checks the other sections of the board so getOut remains true if just one diagonal is found
        if (getOut) {
            win = true;
        }
        return win;
    }
    
    
    //checks player 2's diagonals collectively
    public boolean checkODiagonals() {
        if (checkODiagonalRL() || checkODiagonalLR()) 
            return true;
        else
            return false;
    }
}

