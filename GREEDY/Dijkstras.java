import java.util.*;

public class Dijkstras {
    public static void SSSP(int v, int[][] cost, int[] dis, int n) {
        boolean[] s = new boolean[n];
        Arrays.fill(s, false);
        dis[v] = 0; // Distance from source to itself is 0
        for (int i = 0; i < n - 1; i++) {
            int u = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!s[j] && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            if (u == -1) 
                break; // All remaining vertices are inaccessible
            s[u] = true;
            for (int j = 0; j < n; j++) {
                if (!s[j] && cost[u][j] != 0 && dis[u] != Integer.MAX_VALUE && dis[j] > dis[u] + cost[u][j]) {
                    dis[j] = dis[u] + cost[u][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        System.out.printf("Enter the %dX%d matrix:\n", n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the source vertex: ");
        int s = sc.nextInt();
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0; // Distance from source to itself is 0

        SSSP(s, cost, dis, n);

        System.out.println("Shortest distances from source vertex " + s + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + dis[i]);
        }
    }
}