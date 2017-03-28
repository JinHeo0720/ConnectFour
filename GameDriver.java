
/**
 * Write a description of class GameDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class GameDriver 
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class GameDriver
     */
    public static void main(String[]args)
    {
        //CPU components
        CPU cpu = new CPU();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Connect Four!");
        System.out.println("Would you like to play with a CPU? (Y or N)");
        String answer = scan.next();
        if (answer.toUpperCase().equals("Y")) { //if the person wants ot play with a cpu
            System.out.println("Too bad. Jin was too lazy to create a CPU. Adios.");
        }
        else { //if the person doesn't want to play with the cpu
            System.out.println("Pick a board size (1 or 2):");
            System.out.println("1). 7x7");
            System.out.println("2). 9x9");
            int size = scan.nextInt();
            if (size == 1) { //if the person picks 7x7
                Board7 board = new Board7();
                Player7 p1 = new Player7("X", "Player 1");
                Player7 p2 = new Player7("O", "Player 2");
                board.makeBoard();
                
                //Game Loop remains on until a break is triggered
                
                boolean on = true;
                
                while (on) {
                    //p1's move is stored as a variable which can be used as a parameter
                    int col = p1.move();
                    //check if column is full
                    while (board.checkFull(col - 1)) {
                        System.out.println("That column is full. Choose again. (1-7)");
                        col = p1.move();
                    }
                    //check which row to put p1's piece
                    board.checkColumn(6, col - 1, p1.symbol);
                    //checks for a cat's game
                    if (board.catsGame()) {
                        board.printBoard();
                        System.out.println("Cat's Game!");
                        break;
                    }
                    //check if player 1 has won 
                    if (board.checkXHorizontal() || board.checkXVertical() || board.checkXDiagonals()) {
                        board.printBoard();
                        break;
                    }
                    else {
                        board.printBoard();
                    }
                    
                    
                    //p2's move is stored as a variable which can be used as a parameter
                    int col2 = p2.move();
                    //check if column is full
                    while (board.checkFull(col2 - 1)) {
                        System.out.println("That column is full. Choose again. (1-7)");
                        col2 = p2.move();
                    }
                    //check which row to put p2's
                    board.checkColumn(6, col2 - 1, p2.symbol);
                    //checks for a cat's game
                    if (board.catsGame()) {
                        board.printBoard();
                        System.out.println("Cat's Game!");
                        break;
                    }
                    //check if player 2 has won 
                    if (board.checkOHorizontal() || board.checkOVertical() || board.checkODiagonals()) {
                        board.printBoard();
                        break;
                    }
                    else {
                        board.printBoard();
                    }
                }
            }
            else if (size==2) { //if the person picks 9x9
                Board9 board = new Board9();
                Player9 p1 = new Player9("X", "Player 1");
                Player9 p2 = new Player9("O", "Player 2");
                board.makeBoard();
                
                //Game Loop remains on until a break is triggered
                
                boolean on = true;
                
                while (on) {
                    //p1's move is stored as a variable which can be used as a parameter
                    int col = p1.move();
                    //check if column is full
                    while (board.checkFull(col - 1)) {
                        System.out.println("That column is full. Choose again. (1-7)");
                        col = p1.move();
                    }
                    //check which row to put p1's piece
                    board.checkColumn(8, col - 1, p1.symbol);
                    //checks for a cat's game
                    if (board.catsGame()) {
                        board.printBoard();
                        System.out.println("Cat's Game!");
                        break;
                    }
                    //check if player 1 has won 
                    if (board.checkXHorizontal() || board.checkXVertical() || board.checkXDiagonals()) {
                        board.printBoard();
                        break;
                    }
                    else {
                        board.printBoard();
                    }
                    
                    
                    //p2's move is stored as a variable which can be used as a parameter
                    int col2 = p2.move();
                    //check if column is full
                    while (board.checkFull(col2 - 1)) {
                        System.out.println("That column is full. Choose again. (1-7)");
                        col2 = p2.move();
                    }
                    //check which row to put p2's
                    board.checkColumn(8, col2 - 1, p2.symbol);
                    //checks for a cat's game
                    if (board.catsGame()) {
                        board.printBoard();
                        System.out.println("Cat's Game!");
                        break;
                    }
                    //check if player 2 has won 
                    if (board.checkOHorizontal() || board.checkOVertical() || board.checkODiagonals()) {
                        board.printBoard();
                        break;
                    }
                    else {
                        board.printBoard();
                    }
                }
            }
            else {
                System.out.println("That's not an option. Adios");
            }
        }
    }

}
