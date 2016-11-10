/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author watsk8668
 */
public class Doctor {

    // instance variables
    private int row;
    private int col;

    /**
     * A constructor to create a doctor
     *
     * @param theRow an integer that corresponds to a row on the board
     * @param theCol an integer that corresponds to a column on the board
     */
    public Doctor(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;

    }

    /**
     * Moves the doctor to a specified space around the doctor else to a random
     * space
     *
     * @param newRow an integer that corresponds to a new row on the board
     * @param newCol an integer that corresponds to a new column on the board
     */
    public void move(int newRow, int newCol) {
        // if the player clicks on the dalek it doesnt move
        if (newRow == row && newCol == col) {
            this.row = newRow;
            this.col = newCol;
        } // if the player clicks on any of the 8 spaces around the doctor, move the doctor there
        else if (newRow == row + 1 || newRow == row - 1 || newCol == col + 1 || newCol == col - 1 || (newRow == row + 1 && newCol == col + 1) || (newRow == row + 1 && newCol == col - 1) || (newRow == row - 1 && newCol == col + 1) || (newRow == row - 1 && newCol == col - 1)) {
            row = newRow;
            col = newCol;
        } // else move the doctor to a random space on the board
        else {
            this.row = 0 + (int) (Math.random() * (12 - 0));
            this.col = 0 + (int) (Math.random() * (12 - 0));
        }
    }

    // accessor methods
    /**
     * Returns the row that the doctor is on
     *
     * @return the row that the doctor is on
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column that the doctor is on
     *
     * @return the column that the doctor is on
     */
    public int getCol() {
        return this.col;
    }
}
