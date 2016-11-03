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
    /**
     * 
     * @param doc 
     */
    public void advanceTowards(Doctor doc) {
        // if this dalek has not crashed into another dalek 
        if (this.crash == false) {
            // if the doctor is directly below 
            if (this.row < doc.getRow() && this.col == doc.getCol()) {
                this.row += 1;
            } // if the doctor is directly above
            else if (this.row > doc.getRow() && this.col == doc.getCol()) {
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
    /**
     * Accessor method to get the row that the dalek is on
     * @return this dalek's row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Accessor method to get the column that the dalek is on
     * @return this dalek's column
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Accessor method to ask whether the dalek has crashed
     * @return if this dalek has crashed, true if it has crashed, false if it has not crashed
     */
    public boolean hasCrashed() {
        return this.crash;
    }

    /**
     * Accessor method to crash the daleks 
     * @param a the dalek this dalek is intersecting with
     */
    public void crash(Dalek a) {
        this.crash = true;
    }
}
