
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author watsk8668
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the game board
        Board board = new Board(12,12);
        
        // put a peg at row, column
        board.putPeg(Color.RED, 1, 5);
        board.putPeg(Color.YELLOW, 2, 6);
        
        // remove the peg at row, column
        board.removePeg(1, 5);
        
        // put a message on the board
        board.displayMessage("Please click the board");
        
        while(true){
        // get a click on the board
        Coordinate click = board.getClick();
        // get the row and column
        int row = click.getRow();
        int col = click.getCol();
        // put a peg on the click
        board.putPeg(Color.MAGENTA, row, col);
        
        }
    }
}
