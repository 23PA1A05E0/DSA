import java.util.*;

public class Knapsack_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of objects: ");
        int n = sc.nextInt();

        int[] w = new int[n];
        int[] p = new int[n];

        System.out.println("Enter the weight and profit of each object:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        System.out.print("Enter the capacity of the bag: ");
        int m = sc.nextInt();

        int maxProfit = maxValue(w, p, m, n);
        System.out.println("Maximum Profit: " + maxProfit);

        sc.close();
    }

    public static int maxValue(int[] w, int[] p, int m, int n) {
       
        int[][] k = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    k[i][j] = Math.max(k[i - 1][j], k[i - 1][j - w[i - 1]] + p[i - 1]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }
        System.out.println("Selected objects (weights):");
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (k[i][j] == k[i - 1][j]) {
                i--;
            } else {
                System.out.print(w[i - 1] + " ");
                j = j - w[i - 1];
                i--;
            }
        }
        System.out.println();

        return k[n][m];
    }
}
