import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      int arr[] = new int[n];
      for(int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
      Solution obj = new Solution();
      long ans = obj.partition(arr, k);
      System.out.println(ans);
    }
}


class Solution {
    int n;
    int arr[];
    int k;
    Integer dp[][];
    public int partition(int arr[], int k){
      this.n = arr.length;
      this.arr = arr;
      this.k = k;
      dp = new Integer[n + 1][k + 1];
      return solve(0, 0);
    }

    public int solve(int idx, int cnt){
      if(cnt == k)
        return idx >= n ? 0 : -(int)1e9;
      if(dp[idx][cnt] != null)
        return dp[idx][cnt];
      int sum  = 0;
      int ans = 0;
      for(int j = idx; j < n; j++){
        sum += arr[j];
        ans = Math.max(ans, sum + solve(j + 1, cnt + 1));
      }

      return dp[idx][cnt] = ans;
      
    }
}
