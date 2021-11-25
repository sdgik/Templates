package gik.sd;

class UnionFind {
	private int[] root;
	private int[] rank;
	
	UnionFind(int n) {
		root = new int[n];
		rank = new int[n];
		
		for(int i = 0; i < n; i++) {
			root[i] = i;
			rank[i] = 1;
		}
	}
	
	void union(int v1, int v2) {
		int root1 = find(v1);
		int root2 = find(v2);
		
		if(root1 != root2) {
			if(rank[root1] > rank[root2]) {
				root[root2] = root1;
			} else if(rank[root1] < rank[root2]) {
				root[root1] = root2;
			} else {
				root[root2] = root1;
				rank[root1]++;
			}
		}
	}
	
	int find(int x) {
		if(x == root[x]) {
			return x;
		}
		
		root[x] = find(root[x]);
		return root[x];
	}
	
	boolean connected(int rootX, int rootY) {
		return find(rootX) == find(rootY);
	}
}
