package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   // int x; // got an idea but immediately forgot it, so lets name it just x.
    int rowLenght;
    WeightedQuickUnionUF fullness;
    int TOP;
    int BOTTOM;
    int numOfopenSites;
    boolean grid[][]; // later on, true will mean open position.

    public Percolation(int N){
        if (N < 0) {
            throw new IllegalArgumentException();

        }
        TOP = N * N;
        BOTTOM = (N * N) + 1;
        fullness =  new WeightedQuickUnionUF((N * N) + 2);


        rowLenght = N;
        grid = new boolean[N][N];
        for (int i = 0; i < N - 2; i++){
            for (int j = 0; j < N - 2; j++){
                grid[i][j] = false; //too lazy to check on 'net if it is false by default.
            }
        }
        for(int i = 0; i < N; i++){
            fullness.union(TOP, xyTo1d(0, i));
            fullness.union(BOTTOM, xyTo1d(rowLenght - 1, i));
        }
    }
    public void open(int row, int col){
    /*if((rowLenght - 1) < (row || col)){
        throw new IllegalArgumentException(); } */
        if ( (rowLenght - 1 < row) || (rowLenght - 1 < col) || (col < 0) || (row < 0)) {
                throw new IndexOutOfBoundsException();
    }
    grid[row][col] = true;
     if(row > 0) {
        if(grid[row][col] == grid[row -1][col]){
            fullness.union(xyTo1d(row,col), xyTo1d(row -1, col));

        } }
     if(row < rowLenght - 2){
         if(grid[row][col] == grid[row + 1][col]){
            fullness.union(xyTo1d(row,col),xyTo1d(row + 1,col));

        }}
      if(col > 0){
          if(grid[row][col] == grid[row][col - 1]){
              fullness.union(xyTo1d(row,col), xyTo1d(row, col - 1));

          }
      }
      if(col < rowLenght - 2){
          if(grid[row][col] == grid[row][col + 1]){
              fullness.union(xyTo1d(row,col), xyTo1d(row, col + 1));

          }
      }

    numOfopenSites += 1;
    }
    public boolean isOpen(int row, int col){
        if ( (rowLenght - 1 < row) || (rowLenght - 1 < col) || (col< 0) || (row < 0)) {
            throw new IndexOutOfBoundsException();

        }
        return grid[row][col];
    }
    public boolean isFull(int row, int col){
        if ( (rowLenght - 1 < row) || (rowLenght - 1 < col) || (row < 0) || (col < 0)) {
            throw new IndexOutOfBoundsException();

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
        return col + row * (rowLenght );
    }

}                       
