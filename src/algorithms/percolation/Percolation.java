package algorithms.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF wuf;
    private boolean[][] openSites;
    private int countOpenSites = 0;
    private final int length, BOTTOM, TOP = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("n <= 0");
        }
        //On parcours la liste en commencant par 1.
        length = n;
        this.wuf = new WeightedQuickUnionUF(n * n + 2);
        openSites = new boolean[length][length];
        BOTTOM = length * length + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        //New coordinates.
        checkCoordinates(row, col);
        int newRow = row - 1, newCol = col - 1;
        int site = WQUUFIndex(row - 1, col - 1);
        //Connect to root.
        if(row == 1)
            wuf.union(site, TOP);
        else if(row == length)
            wuf.union(site, BOTTOM);

        if(row + 1 < length && isOpen(row + 1, col)) {
            this.wuf.union(site, WQUUFIndex(newRow + 1, newCol));
        }

        if(row - 1 > 0  && isOpen(row - 1, col)) {
            this.wuf.union(site, WQUUFIndex(newRow - 1, newCol));
        }

        if(col + 1 < length && isOpen(row, col + 1)) {
            this.wuf.union(site, WQUUFIndex(newRow, newCol + 1));
        }

        if(col - 1 > 0 && isOpen(row, col - 1)) {
            this.wuf.union(site, WQUUFIndex(newRow, newCol - 1));
        }

        openSites[newRow][newCol] = true;
        countOpenSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkCoordinates(row, col);
        return openSites[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkCoordinates(row, col);
        return this.wuf.find(WQUUFIndex(row - 1, col - 1)) == this.wuf.find(TOP);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return countOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
         return this.wuf.find(TOP) == this.wuf.find(BOTTOM);
    }

    /*
     * Retourne le coordonnée de l'élément dans le WQFUF.
     */
    private int WQUUFIndex(int row, int col) {
        return row * length + col;
    }

    private void checkCoordinates(int row, int col) {
        if((row < 1 || row > length + 1) && (col < 1 || col > length + 1)) {
            throw new IllegalArgumentException("site coordinates(row=" + row + ", col=" + col + ") not exist in (" + row + ", " + col + ")");
        }
    }
}
