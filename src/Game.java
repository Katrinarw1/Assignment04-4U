
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
        Doctor doc = new Doctor(3, 5);
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

        // create daleks
        Dalek d1 = new Dalek(1, 1);
        board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
        Dalek d2 = new Dalek(4, 8);
        board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
        Dalek d3 = new Dalek(9, 2);
        board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());

        // make the players move
        while (true) {
            // to get a click on the board
            Coordinate click = board.getClick();

            // doctor moves first
            int row = click.getRow();
            int col = click.getCol();
            board.removePeg(doc.getRow(), doc.getCol());
            doc.move(row, col);
            board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

            // move the daleks if they have not crashed
            board.removePeg(d1.getRow(), d1.getCol());
            d1.advanceTowards(doc);
            board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
            if (d1.getRow() == doc.getRow() && d1.getCol() == doc.getCol()) {
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                break;
            }
            if (d1.getRow() == d2.getRow()){
                d1.crash(d2);
                board.putPeg(Color.RED, d1.getRow(), d1.getCol());
            }
            if (d1.getRow() == d3.getRow()){
                d1.crash(d3);
                board.putPeg(Color.RED, d1.getRow(), d1.getCol());
            }

            board.removePeg(d2.getRow(), d2.getCol());
            d2.advanceTowards(doc);
            board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
            if (d2.getRow() == doc.getRow() && d2.getCol() == doc.getCol()) {
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                break;
            }
            if (d2.getRow() == d1.getRow()){
                d2.crash(d1);
                board.putPeg(Color.RED, d2.getRow(), d2.getCol());
            }
            if (d2.getRow() == d3.getRow()){
                d2.crash(d3);
                board.putPeg(Color.RED, d2.getRow(), d2.getCol());
            }

            board.removePeg(d3.getRow(), d3.getCol());
            d3.advanceTowards(doc);
            board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
            if (d3.getRow() == doc.getRow() && d3.getCol() == doc.getCol()) {
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                break;
            }
            if (d3.getRow() == d1.getRow()){
                d3.crash(d1);
                board.putPeg(Color.RED, d3.getRow(), d3.getCol());
            }
            if (d3.getRow() == d2.getRow()){
                d3.crash(d2);
                board.putPeg(Color.RED, d3.getRow(), d3.getCol());
            }
        }
    }
}
