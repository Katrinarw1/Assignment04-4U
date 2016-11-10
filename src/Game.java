
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
        Board board = new Board(12, 12);

        // create the doctor
        Doctor doc = new Doctor((0 + (int) (Math.random() * (12 - 0))), (0 + (int) (Math.random() * (12 - 0))));
        // put a green peg where the doctor is
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

        // array to store the 3 daleks 
        Dalek[] dalek = new Dalek[3];
        // create daleks
        for (int i = 0; i < 3; i++) {
            dalek[i] = new Dalek((0 + (int) (Math.random() * (12 - 0))), (0 + (int) (Math.random() * (12 - 0))));
            // put a black peg where the dalek is 
            board.putPeg(Color.BLACK, dalek[i].getRow(), dalek[i].getCol());
        }

        // tell the user how to move
        board.displayMessage("You are the green peg, click the board to move.");

        // boolean to end the game 
        boolean over = false;

        // make the game happen
        while (over == false) {
            // to get a click on the board
            Coordinate click = board.getClick();

            // check to see if any of the daleks captured the doctor
            for (int i = 0; i < 3; i++) {
                // if the dalek is on the same square as the doctor
                if (doc.getRow() == dalek[i].getRow() && doc.getCol() == dalek[i].getCol()) {
                    // mark the capture with a yellow peg
                    board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                    // tell the player that they lose
                    board.displayMessage("YOU LOSE!!");
                    over = true;
                    // end the game
                    break;
                }
            }

            // check to see if all the daleks have crashed and the doctor is not on the same square
            if (dalek[0].hasCrashed(dalek) && dalek[1].hasCrashed(dalek) && dalek[2].hasCrashed(dalek)) {
                if (doc.getRow() != dalek[0].getRow() && doc.getCol() != dalek[0].getCol()) {
                    // mark the collision with a red peg
                    board.putPeg(Color.RED, dalek[0].getRow(), dalek[0].getCol());
                    // tell the player that they win
                    board.displayMessage("YOU WIN!!");
                    over = true;
                    // end the game
                    break;
                }
            }

            // check to see if any daleks are on the same square
            for (int i = 0; i < 3; i++) {
                if (dalek[i].hasCrashed(dalek)) {
                    // mark the collision with a red peg
                    board.putPeg(Color.RED, dalek[i].getRow(), dalek[i].getCol());
                }
            }

            // doctor moves first
            // remove the doctor's peg
            board.removePeg(doc.getRow(), doc.getCol());
            // move the doctor
            doc.move(click.getRow(), click.getCol());
            // put a new peg where the doctor has moved to
            board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

            // daleks turn
            // move the daleks if they have not crashed
            for (int i = 0; i < 3; i++) {
                if (!dalek[i].hasCrashed(dalek)) {
                    // remove the dalek's peg
                    board.removePeg(dalek[i].getRow(), dalek[i].getCol());
                    // move the dalek
                    dalek[i].advanceTowards(doc);
                    if (dalek[i].hasCrashed(dalek)) {
                        // mark the collision with a red peg
                        board.putPeg(Color.RED, dalek[i].getRow(), dalek[i].getCol());
                    }
                    // if the player loses
                    if (doc.getRow() == dalek[i].getRow() && doc.getCol() == dalek[i].getCol()) {
                        // mark the capture with a yellow peg
                        board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                        // tell the player that they lose
                        board.displayMessage("YOU LOSE!!");
                        over = true;
                        // end
                        break;
                    } // if the player has not won or lost, place the peg and keep playing
                    else if (!dalek[i].hasCrashed(dalek)) {
                        // place the dalek's new peg
                        board.putPeg(Color.BLACK, dalek[i].getRow(), dalek[i].getCol());
                    }
                }
            }
        }
    }
}
