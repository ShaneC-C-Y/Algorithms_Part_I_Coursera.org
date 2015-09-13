import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] count;
    private int experimentsCount;
    private Percolation perc;
        
    public PercolationStats(int n, int t) {
        if (n < 1 || t < 1)
            throw new IndexOutOfBoundsException("Illegal parameter value.");

        int row, col;
        experimentsCount = t;
        count = new double[experimentsCount];
        for (int i = 0; i < experimentsCount; i++) {
            perc = new Percolation(n);
            while (!perc.percolates()) {
                row = StdRandom.uniform(n) + 1;
                col = StdRandom.uniform(n) + 1;
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                    count[i]++;
                }
            }
            count[i] = count[i]/(n*n);
        }
    }
    public double mean() {
        return StdStats.mean(count);
    }
    
    public double stddev() {
        return StdStats.stddev(count);
    }
    
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(experimentsCount));
    }
    
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(experimentsCount));
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats percstats = new PercolationStats(n, t);
        
        System.out.printf("mean                    = %.16f\n", 
                          percstats.mean());
        System.out.printf("stddev                  = %.16f\n", 
                          percstats.stddev());
        System.out.printf("95%% confidence interval = %.16f, %.16f \n", 
                          percstats.confidenceLo(), percstats.confidenceHi());
    }
}