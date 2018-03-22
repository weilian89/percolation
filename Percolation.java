public class Percolation {
    private int n;
	private boolean[] sites;
	
    public Percolation(int n) {
		this.n = n;
		this.sites = new int[n*n];
		for(int i = 0;i<sites.length;i++) {
			this.sites[i] = false;
		}
	}
	
	private int convertIndex(int row, int col) {
		return (row-1) * n + (col - 1);
	}
	
	public void open(int row, int col) {
		this.sites[convertIndex(row, col)] = true;
	
	}
   public    void open(int row, int col)    // open site (row, col) if it is not open already
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   public boolean isFull(int row, int col)  // is site (row, col) full?
   public     int numberOfOpenSites()       // number of open sites
   public boolean percolates()              // does the system percolate?

   public static void main(String[] args)   // test client (optional)
}