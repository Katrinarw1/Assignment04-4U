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

    /**
     * A constructor to create the daleks
     *
     * @param theRow an integer that corresponds to a row on the board
     * @param theCol an integer that corresponds to a column on the board
     */
    public Dalek(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;

    }

    // method to move the daleks towards the doctor
    /**
     * Moves the dalek towards the doctor
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
            } // if the doctor is below and to the left
            else if (this.row < doc.getRow() && this.col < doc.getCol()) {
                this.row += 1;
                this.col += 1;
            } // if the doctor is above and to the left
            else if (this.row > doc.getRow() && this.col < doc.getCol()) {
                this.row -= 1;
                this.col += 1;
            } // if the doctor is below and to the right
            else if (this.row < doc.getRow() && this.col > doc.getCol()) {
                this.row += 1;
                this.col -= 1;
            } // if the doctor is above and to the right
            else if (this.row > doc.getRow() && this.col > doc.getCol()) {
                this.row -= 1;
                this.col -= 1;
            } // if the doctor is directly to the left 
            else if (this.row == doc.getRow() && this.col < doc.getCol()) {
                this.col += 1;
            } // if the doctor is directly to the right
            else if (this.row == doc.getRow() && this.col > doc.getCol()) {
                this.col -= 1;
            }
        }
    }

    // accessor methods
    /**
     * Returns the row that the dalek is on
     *
     * @return this dalek's row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column that the dalek is on
     *
     * @return this dalek's column
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Method to determine whether the dalek has crashed
     *
     * @param dalek the array of daleks
     * @return whether the dalek has crashed, true if it has, false if it hasn't
     */
    public boolean hasCrashed(Dalek dalek[]) {
        // if this dalek is not dalek 1
        if (!this.equals(dalek[0])) {
            // if this dalek is on the same square as dalek 1
            if (this.getRow() == dalek[0].getRow() && this.getCol() == dalek[0].getCol()) {
                crash = true;
            }
        }
        // if this dalek is not dalek 2
        if (!this.equals(dalek[1])) {
            // if this dalek is on the same square as dalek 2
            if (this.getRow() == dalek[1].getRow() && this.getCol() == dalek[1].getCol()) {
                crash = true;
            }
        }
        // if this dalek is not dalek 3
        if (!this.equals(dalek[2])) {
            // if this dalek is on the same square as dalek 3
            if (this.getRow() == dalek[2].getRow() && this.getCol() == dalek[2].getCol()) {
                crash = true;
            }
        }
        return crash;
    }
}
