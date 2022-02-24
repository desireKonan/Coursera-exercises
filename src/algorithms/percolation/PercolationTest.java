package algorithms.percolation;

import edu.princeton.cs.algs4.StdOut;

public class PercolationTest {
    // test client (see below)
    public static void main(String[] args) {
        if(args.length == 0) {
            StdOut.println("Arguments non disponibles !");
        } else {
            int n = Integer.parseInt(args[0]);
            int trials = Integer.parseInt(args[1]);
            PercolationStats percolationStats = new PercolationStats(n, trials);
            String interval = "[" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]";
            StdOut.println("mean                       = " + percolationStats.mean());
            StdOut.println("stddev                     = " + percolationStats.stddev());
            StdOut.println("95% confidence interval    =" + interval);
        }

    }
}
