package algorithms.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private Percolation percolation;
    private double[] sampleFractions;
    private final static double CONFIDENCE_NUMBER = 1.96;
    private final int t;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        sampleFractions = new double[trials];
        t = trials;
        generateExperience(n, trials);
    }


    private void generateExperience(int n, int trials) {
        Stopwatch time = new Stopwatch();
        for (int i = 0; i < trials; i++) {
            percolation = new Percolation(n);
            //La percolation.
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if(!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                }
            }
            //Je retourne la fraction.
            sampleFractions[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        StdOut.println("Le temps d'éxecution est : " + time.elapsedTime());
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(sampleFractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(sampleFractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((double) CONFIDENCE_NUMBER * stddev() / Math.sqrt(this.t));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((double) CONFIDENCE_NUMBER * stddev() / Math.sqrt(this.t));
    }

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
