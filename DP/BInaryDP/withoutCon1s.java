import java.util.*;

class Main{
  public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    Main obj = new Main();
    int n = sc.nextInt();
    int ans = obj.findWays(n, 3);
    System.out.println(ans);
    sc.close();
  }

  Integer dp[][];
  int k;
  public int findWays(int n, int k){
    this.k = k;
    dp = new Integer[n + 1][n + 1];
    return solve(n, 0);
  }

  public int solve(int idx, int length){
    if(idx == 0)
      return 1;
    if(idx < 0)
      return 0;
    
    if(dp[idx][length] != null)
      return dp[idx][length];
    
    int ways = 0;
    //if(length != 0)
    ways += solve(idx - 1, 0);
    if(length < k - 1)
      ways += solve(idx - 1, length + 1);

    return dp[idx][length] = ways;
  }
}
