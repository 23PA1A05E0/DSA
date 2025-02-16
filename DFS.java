import java.util.*;

class DFS {
    private int v;
    private int[][] adj;
    boolean[] visited; 

    public DFS(int v) {
        this.v = v;
        adj = new int[v][v];
        visited = new boolean[v];
        Arrays.fill(visited, false);
    }

    public void Dfs(int start) {
        visited[start] = true; 
        System.out.print(start + " "); 
        for (int i = 0; i < v; i++) {
            if (adj[start][i] == 1 && !visited[i]) {
                Dfs(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();
        DFS graph = new DFS(v);
        System.out.println("Enter the adjacency matrix (" + v + "x" + v + "): ");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph.adj[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Enter the starting vertex for DFS: ");
        int start = scanner.nextInt();
        System.out.println("DFS traversal starting from vertex " + start + ":");
        graph.Dfs(start);
        scanner.close();
    }
}
