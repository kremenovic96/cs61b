package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    int rowLenght;
    WeightedQuickUnionUF fullness;
    int TOP = -1;
    int BOTTOM = -2;
    int numOfopenSites;
    boolean grid[][]; // later on, true will mean open position.

    public Percolation(int N){
        if (N < 0) {
            throw new IllegalArgumentException();
            return;
        }
        fullness =  new WeightedQuickUnionUF(N);

        rowLenght = N;
        grid = new boolean[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                grid[i][j] = false;
            }
        }
        for(int i = 0; i < N; i++){
            fullness.union(TOP, xyTo1d(0, N));
            fullness.union(BOTTOM, xyTo1d(rowLenght -1, N));
        }
    }
    public void open(int row, int col){
    /*if((rowLenght - 1) < (row || col)){
        throw new IllegalArgumentException(); } */
        if ( (rowLenght - 1 < row) || (rowLenght - 1 < col) || (rowLenght < 0) || (rowLenght < 0)) {
                throw new IndexOutOfBoundsException();
                    return;
    }
    grid[row][col] = true;
    // if(row > 0) {
        if(grid[row][col] == grid[row -1][col]){
            fullness.union(xyTo1d(row,col), xyTo1d(row -1, col));
            return;
        } //}
     //if(row < rowLenght - 2){
         if(grid[row][col] == grid[row + 1][col]){
            fullness.union(xyTo1d(row,col),xyTo1d(row + 1,col));
             return;
        }//}
     // if(col > 0){
          if(grid[row][col] == grid[row][col - 1]){
              fullness.union(xyTo1d(row,col), xyTo1d(row, col - 1));
              return;
          }
      //}
     // if(col < rowLenght - 2){
          if(grid[row][col] == grid[row][col + 1]){
              fullness.union(xyTo1d(row,col), xyTo1d(row, col + 1));
              return;
          }
     // }

    numOfopenSites += 1;
    }
    public boolean isOpen(int row, int col){
        if ( (rowLenght - 1 < row) || (rowLenght - 1 < col) || (rowLenght - 1 < 0) || (rowLenght - 1 < 0)) {
            throw new IndexOutOfBoundsException();
            return;
        }
        return grid[row][col];
    }
    public boolean isFull(int row, int col){
        if ( (rowLenght - 1 < row) || (rowLenght - 1 < col) || (rowLenght - 1 < 0) || (rowLenght - 1 < 0)) {
            throw new IndexOutOfBoundsException();
            return;
        }
        return fullness.connected(TOP, xyTo1d(row,col));
    }
    public int numberOfOpenSites(){
        return numOfopenSites;
    }
    public boolean percolates(){
    return fullness.connected(TOP, BOTTOM);
    }
    private int xyTo1d(int row, int col){
        return col + row * (rowLenght -1);
    }

}                       
