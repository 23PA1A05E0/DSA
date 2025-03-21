import java.util.*;

class DFSAdjList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices and edges::");
        int v = sc.nextInt();
        int e = sc.nextInt();
        System.out.println("Enter the src and dest of each edges");
        DFS graph = new DFS(v);
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.add(s, d);
        }
        System.out.print("Enter the source vertex::");
        int start = sc.nextInt();
        graph.dfs(start);
    }
}

class DFS {
    int v;
    LinkedList<Integer> adj[];
    boolean[] visited;

    public DFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void add(int src, int des) {
        adj[src].add(des);
        adj[des].add(src);
    }

    public void dfs(int start) {
        visited = new boolean[v]; // Initialize the visited array
        System.out.println("Graph traversing from vertex: " + start);
        dfsHelper(start);
    }

    public void dfsHelper(int start) {
        visited[start] = true;
        System.out.println("Vertex --> " + start);
        for (int i : adj[start]) {
            if (!visited[i]) {
                dfsHelper(i);
            }
        }
    }
}
