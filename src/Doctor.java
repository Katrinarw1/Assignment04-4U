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

    public void move(int newRow, int newCol) {
        if (this.getRow() == row + 1) {
            this.row += 1;
        } else if (this.getRow() == row - 1) {
            this.row -= 1;
        } else if (this.getCol() == col + 1) {
            this.col += 1;
        } else if (this.getCol() == col - 1) {
            this.col -= 1;
        } else if (this.getRow() == row + 1 & this.getCol() == col + 1) {
            this.row += 1;
            this.col += 1;
        } else if (this.getRow() == row - 1 & this.getCol() == col + 1) {
            this.row -= 1;
            this.col += 1;
        } else if (this.getRow() == row + 1 & this.getCol() == col - 1) {
            this.row += 1;
            this.col -= 1;
        } else if (this.getRow() == row - 1 & this.getCol() == col - 1) {
            this.row -= 1;
            this.col -= 1;
        } else {
            this.row = (int) (Math.random()) * 12;
            this.col = (int) (Math.random()) * 12;
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
