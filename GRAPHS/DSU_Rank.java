class DSU{
    int n;
    int parent[];
    int rank[];
    public DSU(int n){
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findParent(int node){
        if(node == parent[node])
            return node;
        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv)
            return;
        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }
        else if(rank[pv] > rank[pu])
            parent[pu] = pv;
        else{
            parent[pu] = pv;
            rank[pv] += 1;
        }
    }
}
