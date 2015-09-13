import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private int N;
    private WeightedQuickUnionUF ufHelper;
    
    public Percolation(int n)
    {
        N = n;
        if (N < 1)
            throw new IndexOutOfBoundsException("Illegal parameter value in N.");
        grid = new boolean[N][N];
        ufHelper = new WeightedQuickUnionUF((N * N) + 2);
    }
    
    public void open(int i, int j) //unmodified i : 1~N
    {
        int row = i-1; //0~N-1
        int col = j-1;
        if (row < 0 || row > N || col < 0 || col > N)
            throw new IndexOutOfBoundsException("Illegal parameter value in open.");
        grid[row][col] = true;
        
        if (row == 0)
            ufHelper.union(0, xyTo1D(row, col));
        if (row == N - 1)
            ufHelper.union(N*N + 1, xyTo1D(row, col));
        if (row > 0) {
            if (grid[row - 1][col])
                ufHelper.union(xyTo1D(row - 1, col), xyTo1D(row, col));
        }
        if (row < N - 1) {
            if (grid[row + 1][col])
                ufHelper.union(xyTo1D(row + 1, col), xyTo1D(row, col));
        }
        if (col > 0) {
            if (grid[row][col - 1])
                ufHelper.union(xyTo1D(row, col - 1), xyTo1D(row, col));
        }
        if (col < N - 1) {
            if (grid[row][col + 1])
                ufHelper.union(xyTo1D(row, col + 1), xyTo1D(row, col));
        }
    }
    
    private int xyTo1D(int i, int j) //modified i : 0~N-1
    {
        return ((i*N)+j) + 1;
    }
    
    public boolean isOpen(int i, int j)
    {
        int row = i-1;
        int col = j-1;
        if (row < 0 || row > N || col < 0 || col > N)
            throw new IndexOutOfBoundsException("Illegal parameter value.");
        return grid[row][col];
    }
    
    public boolean isFull(int i, int j)
    {
        int row = i-1;
        int col = j-1;
        if (row < 0 || row > N || col < 0 || col > N)
            throw new IndexOutOfBoundsException("Illegal parameter value.");
        return ufHelper.connected(0, xyTo1D(row, col));
    }
    
    public boolean percolates()
    {
        return ufHelper.connected(0, (N*N)+1);
    }
    
//    public static void main(String [] args)
//    {
//        int n = Integer.parseInt(args[0]);
//        Percolation perc = new Percolation(n);
//        
//        double count = 0;
//        int row, col;
//        while (!perc.percolates()) {
//            row = StdRandom.uniform(n) + 1;
//            col = StdRandom.uniform(n) + 1;
//
//            if (!perc.isOpen(row, col)) {
//                perc.open(row, col);
//                System.out.printf("%d, %d\n", row, col);
//                count++;
//            }
//        }
//    }   
}