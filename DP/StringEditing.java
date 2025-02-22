import java.util.*;

public class StringEditing {
    public static int minDistance(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        int i, j;
        int c[][] = new int[n + 1][m + 1];

        // Initialize the table
        for (i = 0; i <= n; i++)
            c[i][0] = i;
        for (j = 0; j <= m; j++)
            c[0][j] = j;

        // Fill the table
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1];
                } else {
                    c[i][j] = Math.min(c[i - 1][j - 1] + 2, Math.min(c[i][j - 1] + 1, c[i - 1][j] + 1));
                }
            }
        }
        return c[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string::");
        String X = sc.nextLine();
        System.out.print("Enter the second string::");
        String Y = sc.nextLine();
        int min = minDistance(X, Y);
        System.out.printf("Minimum Distance is::%d\n", min);
    }
}
