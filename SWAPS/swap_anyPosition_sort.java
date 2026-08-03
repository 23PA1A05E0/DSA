import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            // String b = sc.next();
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.minSwaps(a);
            System.out.println(ans);
        }
    }
}

class Solution{
    public int minSwaps(int arr[]){
        int n = arr.length;
        int sorted[] = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> mpp = new HashMap<>();
        int idx[] = new int[n];
        for(int i = 0; i < n; i++)
            mpp.put(sorted[i], i);
        for(int i = 0; i < n; i++)
            idx[i] = mpp.get(arr[i]);

        boolean vis[] = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            int val = dfs(i, vis, idx);
            if(val != 0)
                ans += val - 1;
        }

        return ans;
    }

    public int dfs(int i, boolean vis[], int idx[]){
        if(vis[i])
            return 0;
        vis[i] = true;
        
        return 1 + dfs(idx[i], vis, idx);  
    }
}

