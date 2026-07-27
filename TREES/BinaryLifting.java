class BinaryLifting {

    int up[][];

    public BinaryLifting(int n, int[] parent) {

        int col = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[n][col];
        for (int node = 0; node < n; node++) {
            up[node][0] = parent[node];
        }
        for (int j = 1; j < col; j++) {
            for (int node = 0; node < n; node++) {
                if (up[node][j - 1] != -1) {
                    up[node][j] = up[up[node][j - 1]][j - 1];
                } else {
                    up[node][j] = -1;
                }
            }
        }

        // for (int j = 0; j < col; j++) {
        //     for (int node = 0; node < n; node++)
        //         System.out.print(up[node][j] + " ");
        //     System.out.println();
        // }
    }

    public int getKthAncestor(int node, int k) {

        int col = up[0].length;
        for (int j = 0; j < col; j++) {
            if (node == -1)
                return -1;
            if ((k & (1 << j)) != 0)
                node = up[node][j];
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
