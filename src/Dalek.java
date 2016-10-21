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
    public Dalek(int theRow, int theCol){
        this.row = theRow;
        this.col = theCol;
        
    }

    public void advanceTowards(Doctor doc){
        if(this.crash == false){
            /* case 1: this.row += 1;
             * case 2: this.row -= 1;
             * case 3: this.row += 1; & this.col += 1;
             * case 4: this.row -= 1; & this.col += 1;
             * case 5: this.row += 1; & this.col -= 1;
             * case 6: this.row -= 1; & this.col -= 1;
             * case 7: this.col += 1; 
             * case 8: this.col -= 1;
             * case 9: this.row = this.row; & this.col = this.col;
             */
        }
    }
    
    // accessor methods
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public boolean hasCrashed(){
        return this.crash;
    }
    
    public void crash(Dalek a){
        this.crash = true;
    }
}
