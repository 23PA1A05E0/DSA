/// Time Complexity : O(n)

import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int idx = solve(a,n);
        System.out.println(idx);
    }
    
    public static int solve(int a[], int n){
        int ele[] = new int[n];
        for(int i=0;i<n-1;i++){
            int cnt = 0;
            for(int j=i+1;j<n;j++){
                if(a[i] > a[j])
                    cnt++;
            }
            ele[i] = cnt;
        }
        ele[n-1] = 0;
        int ans = 0;
        int ite = 0;
        for(int i=n-1;i>=0;i--){
            ans = ans + ele[i] * ite;
            ite++;
        }
        return ans + 1;
    }
}




















/// Time Complexity : O(NlogN)
import java.util.*;
class BeingInfinity{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int idx = solve(a,n);
        System.out.println(idx);
    }
    
    public static int solve(int a[], int n) {
    int ele[] = nextSmaller(a, n);
    int ans = 0;
    int factorial = 1;
    
    for (int i = n - 1; i >= 0; i--) {
        ans += ele[i] * factorial;
        factorial *= (n - i);  
    }
    return ans + 1;
}
    
    public static int[] nextSmaller(int a[], int n){
        int ele[] = new int[n];
        List<Integer> seen = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            int pos = insertPosition(seen,a[i]);
            ele[i] = pos;
            seen.add(pos,a[i]);
        }
        return ele;
    }
    
    public static int insertPosition(List<Integer> arr, int k){
        if(arr.isEmpty())
            return 0;
        if(arr.get(0) > k)
            return 0;
        if(arr.get(arr.size() - 1) < k)
            return arr.size();
        int low = 0;
        int high = arr.size() - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr.get(mid) >= k){
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
}
