// /* Definition for Node
// class Node {
//     public int data;
//     public Node left;
//     public Node right;

//     public Node(int val) {
//         data = val;
//         left = right = null;
//     }
// };
// */

class Solution {
    int parent[];
    int up[][];
    int n;
    public int kthAncestor(Node root, int k, int p) {
        // code here
        n = 0;
        countNodes(root);
        parent = new int[n + 1];
        int col = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[n + 1][col];
        findParent(root, -1);
        
        for(int i = 0; i <= n; i++)
            up[i][0] = parent[i];
        
        
        for(int j = 1; j < col; j++){
            
            for(int node = 0; node <= n; node++){
                if(up[node][j - 1] != -1)
                    up[node][j] = up[up[node][j - 1]][j - 1];
                else
                    up[node][j] = -1;
            }
        }
        
        for(int j = 0; j < col; j++){
            if(p == -1)
                return -1;
                
            if((k & (1 << j)) != 0)
                p = up[p][j];
        }
        return p;
        
    }
    
    
    
    public void findParent(Node root, int par){
        if(root == null)
            return;
        parent[root.data] = par;
        
        findParent(root.left, root.data);
        findParent(root.right, root.data);
    }
    
    
    public void countNodes(Node root){
        if(root == null)
            return;
        n++;
        countNodes(root.left);
        countNodes(root.right);
    }
}












//Special Edition

class Solution {
    int parent[];
    int n;
    int dp[][];
    int depth[];

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode pa, TreeNode qa) {
        if (root == null)
            return root;

        n = 0;
        cntNodes(root);

        parent = new int[n];
        depth = new int[n];

        Arrays.fill(parent, -1);

        buildParent(root, -1, 0);

        int col = (int)(Math.log(n) / Math.log(2)) + 1;

        dp = new int[n][col];

        for (int i = 0; i < n; i++)
            dp[i][0] = parent[i];

        for (int j = 1; j < col; j++) {
            for (int node = 0; node < n; node++) {
                if (dp[node][j - 1] != -1)
                    dp[node][j] = dp[dp[node][j - 1]][j - 1];
                else
                    dp[node][j] = -1;
            }
        }

        int p = pa.val;
        int q = qa.val;

        // Make p the deeper node
        if (depth[p] < depth[q]) {
            int temp = p;
            p = q;
            q = temp;
        }

        // Bring p to same depth as q
        int diff = depth[p] - depth[q];

        for (int j = 0; j < col; j++) {
            if ((diff & (1 << j)) != 0)
                p = dp[p][j];
        }

        // Same node
        if (p == q)
            return findNode(root, p);

        // Lift both nodes
        for (int j = col - 1; j >= 0; j--) {
            if (dp[p][j] != dp[q][j]) {
                p = dp[p][j];
                q = dp[q][j];
            }
        }

        // Parent of p and q is LCA
        int lca = parent[p];

        return findNode(root, lca);
    }

    public TreeNode findNode(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        TreeNode left = findNode(root.left, val);

        if (left != null)
            return left;

        return findNode(root.right, val);
    }

    public void cntNodes(TreeNode root) {
        if (root == null)
            return;

        n++;

        cntNodes(root.left);
        cntNodes(root.right);
    }

    public void buildParent(TreeNode root, int par, int d) {
        if (root == null)
            return;

        parent[root.val] = par;
        depth[root.val] = d;

        buildParent(root.left, root.val, d + 1);
        buildParent(root.right, root.val, d + 1);
    }
}
