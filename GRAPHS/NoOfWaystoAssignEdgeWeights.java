class Solution {
    int n;
    int up[][];
    int depth[];
    List<List<Integer>> g;
    int col;
    int MOD = (int) 1e9 + 7;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n = edges.length;
        n = n + 2;
        col = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[n][col];
        depth = new int[n];
        g = new ArrayList<>();
        //Build Adj List
        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }


        for (int i = 0; i < n; i++)
            Arrays.fill(up[i], -1);

        up[1][0] = -1;
        depth[1] = 0;

        findParent(1, -1);

        //Ancestor Table constructing
        for (int j = 1; j < col; j++) {
            for (int node = 1; node < n; node++) {
                if (up[node][j - 1] != -1)
                    up[node][j] = up[up[node][j - 1]][j - 1];
                else
                    up[node][j] = -1;
            }
        }

        int[] two = new int[n];
        two[0] = 1;
        for (int i = 1; i < n; i++)
            two[i] = (int) ((2L * two[i - 1]) % MOD);
        

        int res[] = new int[queries.length];
        int idx = 0;
        for (int q[] : queries) {
            int u = q[0];
            int v = q[1];
            int lca = findLCA(u, v);

            int du = depth[u];
            int dv = depth[v];
            int c = depth[lca];

            int pow = du + dv - 2 * c;
            
            if (pow == 0)
                res[idx++] = 0;
            else
                res[idx++] = two[pow - 1];
        }

        return res;

    }

    public int findLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int k = depth[u] - depth[v];

        for (int j = 0; j < col; j++) {
            if ((k & (1 << j)) != 0)
                u = up[u][j];
        }

        if (u == v)
            return u;

        for (int j = col - 1; j >= 0; j--) {
            if (up[u][j] == -1)
                continue;
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }

    public void findParent(int root, int parent) {
        for (int neigh : g.get(root)) {
            if (parent == neigh)
                continue;
            up[neigh][0] = root;
            depth[neigh] = depth[root] + 1;
            findParent(neigh, root);
        }
    }
}
