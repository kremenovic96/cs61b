package hw2;
 import edu.princeton.cs.introcs.StdRandom;
 import edu.princeton.cs.introcs.StdStats;
public class PercolationStats {
   public PercolationStats(int N, int T){
       if((N < 1) || (T < 1)){
           throw new IllegalArgumentException();
       }
   }
    public double mean(){return 0;}
    public double stddev(){return 0;}
    public double confidenceLow(){return 0;}
    public double confidenceHigh(){return 0;}


}                       
