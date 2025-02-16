import java.util.*;

class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");
        int v = sc.nextInt();
        BFSAdjMatrix graph = new BFSAdjMatrix(v);
        System.out.println("Enter the adjacency matrix (" + v + "x" + v + "):");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph.adj[i][j] = sc.nextInt();
                if (graph.adj[i][j] != 0 && graph.adj[i][j] != 1) {
                    System.out.println("Invalid input! Adjacency matrix should contain only 0s and 1s.");
                    return;
                }
            }
        }
        System.out.println("Enter the starting vertex for BFS (0 to " + (v - 1) + "):");
        int start = sc.nextInt();
        if (start < 0 || start >= v) {
            System.out.println("Invalid starting vertex! It should be between 0 and " + (v - 1) + ".");
            return;
        }
        System.out.println("BFS traversal starting from vertex " + start + ":");
        graph.BFS(start);
        sc.close();
    }
}

class BFSAdjMatrix {
    private int v;
    int adj[][]; 
    public BFSAdjMatrix(int v) {
        this.v = v;
        this.adj = new int[v][v];
    }
    public void BFS(int start) {
        boolean visited[] = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int vis = queue.poll(); 
            System.out.print(vis + " ");
            for (int i = 0; i < v; i++) {
                if (adj[vis][i] == 1 && !visited[i]) {
                    visited[i] = true; 
                    queue.add(i); 
                }
            }
        }
    }
}
