import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      Solution obj = new Solution();
      long ans = obj.numSubseq(s);
      System.out.println(ans);
    }
}


class Solution {
    int n;
    String s;
    Long [][][]dp;
    int MOD = (int)1e9 + 7;
    int x;
    public long numSubseq(String s) {
        this.n = s.length();
        this.s = s;
        dp = new Long[n][n][n];
        return solve(0, 0, 0);
    }

    public long solve(int idx, int zero, int ones){
        if(idx >= n){
            if(zero == 0 && ones == 0)
              return 0;
            return Math.abs(ones - zero) % 3 == 0 ? 1 : 0;
        }
        if(dp[idx][zero][ones] != null)
            return dp[idx][zero][ones];
        //System.out.println(ones + "  " + zero);
        long take = 0;
        if(s.charAt(idx) == '0')
          take = solve(idx + 1, zero + 1, ones);
        else
          take += solve(idx + 1, zero, ones + 1);

        long notTake = solve(idx + 1, zero, ones);

        return dp[idx][zero][ones] = (take + notTake) % MOD;
    }
}
