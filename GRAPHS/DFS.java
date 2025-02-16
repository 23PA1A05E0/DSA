import java.util.*;

class DFS {
    private int v;
    private int[][] adj;
    private boolean[] visited; 

    public DFS(int v) {
        this.v = v;
        this.adj = new int[v][v];
        this.visited = new boolean[v];
    }

    public void dfs(int start) {
        Arrays.fill(visited, false);
        System.out.println("DFS traversal starting from vertex " + start + ":");
        dfsHelper(start);
    }
    private void dfsHelper(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < v; i++) {
            if (adj[start][i] == 1 && !visited[i]) {
                dfsHelper(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();
        DFS graph = new DFS(v);
        System.out.println("Enter the adjacency matrix (" + v + "x" + v + "):");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph.adj[i][j] = scanner.nextInt();
                if (graph.adj[i][j] != 0 && graph.adj[i][j] != 1) {
                    System.out.println("Invalid input! Adjacency matrix should contain only 0s and 1s.");
                    return;
                }
            }
        }
        System.out.print("Enter the starting vertex for DFS (0 to " + (v - 1) + "): ");
        int start = scanner.nextInt();
        if (start < 0 || start >= v) {
            System.out.println("Invalid starting vertex! It should be between 0 and " + (v - 1) + ".");
            return;
        }
        graph.dfs(start);

        scanner.close();
    }
}
