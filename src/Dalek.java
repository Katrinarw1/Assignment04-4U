/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author watsk8668
 */
public class Dalek {
    // instance variables

    private int row;
    private int col;
    private boolean crash = false;

    // constructor
    public Dalek(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;

    }
    // method to move the daleks towards the doctor

    public void advanceTowards(Doctor doc) {
        if (this.crash == false) {
            if (this.row < doc.getRow() && this.col == doc.getCol()) {
                this.row += 1;
            } else if (this.row > doc.getRow() && this.col == doc.getCol()) {
                this.row -= 1;
            } else if (this.row < doc.getRow() && this.col < doc.getCol()) {
                this.row += 1;
                this.col += 1;
            } else if (this.row > doc.getRow() && this.col < doc.getCol()) {
                this.row -= 1;
                this.col += 1;
            } else if (this.row < doc.getRow() && this.col > doc.getCol()) {
                this.row += 1;
                this.col -= 1;
            } else if (this.row > doc.getRow() && this.col > doc.getCol()) {
                this.row -= 1;
                this.col -= 1;
            } else if (this.row == doc.getRow() && this.col < doc.getCol()) {
                this.col += 1;
            } else if (this.row == doc.getRow() && this.col > doc.getCol()) {
                this.col -= 1;
            }
        }
    }

    // accessor methods
    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public boolean hasCrashed() {
        return this.crash;
    }

    public void crash(Dalek a) {
        this.crash = true;
    }
}
