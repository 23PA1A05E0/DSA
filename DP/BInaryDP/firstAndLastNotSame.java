import java.util.*;

class Main{
  public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    Main obj = new Main();
    int n = sc.nextInt();
    int k = sc.nextInt();
    int ans = obj.findWays(n, k);
    System.out.println(ans);
    sc.close();
  }

  Integer dp[][][];
  int k;
  public int findWays(int n, int k){
    this.k = k;
    dp = new Integer[n + 1][2][k];
    int ways = solve(n - 1, 0, 0);
    ways += solve(n - 1, 1, 1);
    return ways;
  }

  public int solve(int idx, int first, int length){
    if(idx == 0){
      int last = (length == 0) ? 0 : 1;
      return first != last ? 1 : 0;
    }
    if(idx < 0)
      return 0;
    
    if(dp[idx][first][length] != null)
      return dp[idx][first][length];
    
    int ways = 0;
    
    ways += solve(idx - 1, first, 0);
    if(length < k - 1)
      ways += solve(idx - 1, first, length + 1);

    return dp[idx][first][length] = ways;
  }
}
