import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices and edges:");
        int v = sc.nextInt();
        int e = sc.nextInt();
        BFS graph = new BFS(v);

        System.out.println("Enter the src and dest of each edge:");
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.add(s, d);
        }

        System.out.println("Enter starting vertex:");
        int start = sc.nextInt();
        graph.bfs(start);
    }
}

class BFS {
    private LinkedList<Integer> adj[];
    private int v;

    public BFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void add(int start, int des) {
        adj[start].add(des);
        adj[des].add(start);
    }

    public void bfs(int start) {
        boolean visited[] = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        System.out.println("BFS traversal starting from vertex " + start + ":");
        while (!queue.isEmpty()) {
            int vis = queue.poll();
            System.out.print(vis + " ");

            for (int i : adj[vis]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }
}
