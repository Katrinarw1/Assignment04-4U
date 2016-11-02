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

    // constructor
    public Doctor(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;

    }

    // to move the doctor
    public void move(int newRow, int newCol) {
        if (newRow == row + 1 || newRow == row - 1 || newCol == col + 1 || newCol == col - 1 || (newRow == row + 1 && newCol == col + 1) || (newRow == row + 1 && newCol == col - 1) || (newRow == row - 1 && newCol == col + 1) || (newRow == row - 1 && newCol == col - 1)) {
            row = newRow;
            col = newCol;
        } else {
            this.row = 0 + (int) (Math.random() * (12 - 0));
            this.col = 0 + (int) (Math.random() * (12 - 0));
        }
    }

    // accessor methods
    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
