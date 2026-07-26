class DSU{
    int n;
    int parent[];
    int size[];
    public DSU(int n){
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
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
        if(size[pu] >= size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}
