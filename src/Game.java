
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

    public int rand(int max, int min){
         return min + (int) (Math.random() * ((max - min) + 1));
    }
    
    
    /**
     * @param args the command line arguments
     */
    /*// put a peg at row, column
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
        
     }*/
    public static void main(String[] args) {
        // create the game board
        Board board = new Board(12, 12);

        // doctor
        Doctor doc = new Doctor(rand(12, 0), 5);
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

        // daleks
        Dalek d1 = new Dalek(1, 1);
        board.putPeg(Color.YELLOW, d1.getRow(), d1.getCol());
        Dalek d2 = new Dalek(4, 8);
        board.putPeg(Color.YELLOW, d2.getRow(), d2.getCol());
        Dalek d3 = new Dalek(9, 2);
        board.putPeg(Color.YELLOW, d3.getRow(), d3.getCol());

        // make the players move
        while (true) {
            // get a click on the board
            Coordinate click = board.getClick();
            // doctor moves first
            int row = click.getRow();
            int col = click.getCol();
            doc.move(row, col);
            
            // move the daleks if they have not crashed
            if(d1.hasCrashed() == false){
                d1.advanceTowards(doc);
            }
            if(d2.hasCrashed() == false){
                d2.advanceTowards(doc);
            }
            if(d3.hasCrashed() == false){
                d3.advanceTowards(doc);
            }
        }
    }
}
