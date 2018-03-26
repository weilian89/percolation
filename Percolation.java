public class Percolation {
    private int n;
	private boolean[] isOpenSites;
	private int[] sites;
	private int[] weight;
	private int openCount;
	
    public Percolation(int n) {
		this.n = n;
		this.openCount = 0;
		this.sites = new int[n*n + 2];
		this.weight = new int[n*n+2];
		this.isOpenSites = new boolean[n*n+2];
		
		for(int i = 0;i<isOpenSites.length;i++) {
			isOpenSites[i] = false;
		}
		isOpenSites[0] = true;
		isOpenSites[isOpenSites.length-1] = true;
		for(int i = 0;i<sites.length;i++) {
			this.sites[i] = i;
			this.weight[i] = 1;
		}
	}
	
	private void union(int item1, int item2) {
		int root1 = root(item1);
		int root2 = root(item2);
		if(root1 == root2) {
			//do nothing
		} else {
			int weight1 = weight[root1];
			int weight2 = weight[root2];
			
			if(weight1 > weight2) {
				sites[root2] = root1;
				weight[root1] += weight2;
			}else {
				sites[root1] = root2;
				weight[root2] += weight1;
			}
		
		}
	}
	
	private boolean find(int item1, int item2) {
		int root1 = root(item1);
		int root2 = root(item2);
		
		return root1 == root2;
	}
	
	private int root(int item) {
		
		int current = item;
		
		while(sites[current] != current) {
			current = sites[current];
		}
		
		return current;
	}
	
	private int convertIndex(int row, int col) {
		return (row-1) * n + (col - 1) + 1;
	}
	
	public void open(int row, int col) {
		if(this.isOpen(row, col))
			return ;
		int index = convertIndex(row, col);
		
		this.isOpenSites[index] = true;
		
		//union up
		if(row == 1) {
			this.union(index, 0);
		} else {
			if(isOpen(row - 1, col)) {
				this.union(index, convertIndex(row-1, col));
			}
		}
		//union down
		if(row == n) {
			this.union(index, n*n+1);
		} else {
			if(isOpen(row+1, col)) {
				this.union(index, convertIndex(row+1, col));
			}
		}
		
		//union left
		if(col != 1) {
			if(isOpen(row, col-1)) {
				this.union(index, convertIndex(row, col-1));
			}
		}
		
		//union right
		if(col != n) {
			if(isOpen(row, col+1)) {
				this.union(index, convertIndex(row, col+1));
			}
		}
		openCount++;
		
	
	}
	
	public boolean isOpen(int row, int col) {
		return this.isOpenSites[convertIndex(row, col)];
	}
	
    public boolean isFull(int row, int col) {
        return this.openCount == n*n;
    }
	
	public int numberOfOpenSites() {
		return this.openCount;
    }
	
	public boolean percolates() {
		return this.find(0, n*n+1);
	}
	
    public static void main(String[] args) {
		Percolation p = new Percolation(6);
		
		for(int i = 1;i<=6;i++) {
			p.open(i, 3);
			System.out.println(p.percolates());
		}
	
	}
}