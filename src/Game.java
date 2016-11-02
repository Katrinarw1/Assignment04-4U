
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

    public int rand(int max, int min) {
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

        // create doctor
        Doctor doc = new Doctor((0 + (int) (Math.random() * (12 - 0))), 5);
        // put a green peg where the doctor is
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

        // create daleks
        // dalek 1
        Dalek d1 = new Dalek(1, 1);
        // put a black peg where the dalek is 
        board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
        // dalek 2
        Dalek d2 = new Dalek(4, 8);
        // put a black peg where the dalek is 
        board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
        // dalek 3
        Dalek d3 = new Dalek(9, 2);
        // put a black peg where the dalek is 
        board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());

        // make the game happen
        while (true) {
            // to get a click on the board
            Coordinate click = board.getClick();

            // doctor moves first
            // get the doctor's row and column
            int row = click.getRow();
            int col = click.getCol();
            // remove the doctor's peg
            board.removePeg(doc.getRow(), doc.getCol());
            // move the doctor
            doc.move(row, col);
            // put a new peg where the doctor had moved to
            board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

            // move the daleks if they have not crashed
            // move dalek 1
            // remove dalek 1's peg
            board.removePeg(d1.getRow(), d1.getCol());
            // make dalek 1 move towards the doctor
            d1.advanceTowards(doc);
            // put a black peg in dalek 1's new place
            board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
            
            // if dalek 1 captures the doctor
            if (d1.getRow() == doc.getRow() && d1.getCol() == doc.getCol()) {
                // put a yellow peg on the spot
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                // end the game
                break;
            }
            
            // if dalek 1 and dalek 2 intersect
            if (d1.getRow() == d2.getRow() && d1.getCol() == d2.getCol()){
                // crash for dalek 1 and dalek 2 is true
                d1.crash(d2);
                // put a red peg to mark the spot
                board.putPeg(Color.RED, d1.getRow(), d1.getCol());
            }
            // if dalek 1 and dalek 3 intersect
            if (d1.getRow() == d3.getRow() && d1.getCol() == d3.getCol()){
                // crash for dalek 1 and dalek 3 is true
                d1.crash(d3);
                // put a red peg to mark the spot
                board.putPeg(Color.RED, d1.getRow(), d1.getCol());
            }

            // move dalek 2
            // remove dalek 2's peg
            board.removePeg(d2.getRow(), d2.getCol());
            // make dalek 2 move towards the doctor
            d2.advanceTowards(doc);
            // put a black peg in dalek 2's new place
            board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
            
            // if dalek 2 captures the doctor
            if (d2.getRow() == doc.getRow() && d2.getCol() == doc.getCol()) {
                // put a yellow peg on the spot
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                // end the game
                break;
            }
            
            // if dalek 2 and dalek 1 intersect
            if (d2.getRow() == d1.getRow() && d2.getCol() == d1.getCol()){
                // crash for dalek 2 and dalek 1 is true
                d2.crash(d1);
                // put a red peg to mark the spot
                board.putPeg(Color.RED, d2.getRow(), d2.getCol());
            }
            // if dalek 2 and dalek 3 intersect
            if (d2.getRow() == d3.getRow() && d2.getCol() == d3.getCol()){
                // crash for dalek 2 and dalek 3 is true
                d2.crash(d3);
                // put a red peg to mark the spot
                board.putPeg(Color.RED, d2.getRow(), d2.getCol());
            }

             // move dalek 3
            // remove dalek 3's peg
            board.removePeg(d3.getRow(), d3.getCol());
            // make dalek 3 move towards the doctor
            d3.advanceTowards(doc);
            // put a black peg in dalek 3's new place
            board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
            
             // if dalek 3 captures the doctor
            if (d3.getRow() == doc.getRow() && d3.getCol() == doc.getCol()) {
                // put a yellow peg on the spot
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                // end the game
                break;
            }
            
            // if dalek 3 and dalek 1 intersect
            if (d3.getRow() == d1.getRow() && d3.getCol() == d1.getCol()){
                // crash for dalek 3 and dalek 1 is true
                d3.crash(d1);
                 // put a red peg to mark the spot
                board.putPeg(Color.RED, d3.getRow(), d3.getCol());
            }
            // if dalek 3 and dalek 2 intersect
            if (d3.getRow() == d2.getRow() && d3.getCol() == d2.getCol()){
                // crash for dalek 3 and dalek 2 is true
                d3.crash(d2);
                 // put a red peg to mark the spot
                board.putPeg(Color.RED, d3.getRow(), d3.getCol());
            }
        }
    }
}
