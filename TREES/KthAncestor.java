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
