import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            Solution obj = new Solution();
            int n = sc.nextInt();
            // int m = sc.nextInt();
            // int mat[][] = new int[n][m];
            // for(int i = 0; i < n; i++){
            //     for(int j = 0; j < m; j++){
            //         mat[i][j] = sc.nextInt();
            //     }
            // }
            // List<List<Integer>> ans = new ArrayList<>();
            // System.out.println("--------VALUE PATH----------");
            // ans = obj.valuePath(mat);
            // for(List<Integer> row : ans){
            //     for(int cell : row)
            //         System.out.print(cell + " ");
            //     System.out.println();
            // }
            // System.out.println();

            // System.out.println("--------EDGE PATH----------");
            // obj.edgePath(mat);
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println("Using Visited Array : ");
            obj.generate(arr);
            System.out.println("Using Swaping Techique");
            obj.generate2(arr);
        }
    }
}



class Solution{
    int arr[];
    int n;
    boolean vis[];
    List<Integer> subList;
    void generate(int arr[]){
        this.n = arr.length;
        this.arr = arr;
        subList = new ArrayList<>();
        vis = new boolean[n];
        solve();
    }
    
    void solve(){
        if(subList.size() == n){
            for(int ele : subList)
                System.out.print(ele + " ");
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(vis[i])
                continue;
            vis[i] = true;
            subList.add(arr[i]);
            solve();
            subList.remove(subList.size() - 1);
            vis[i] = false;
        }
    }
    
    void generate2(int arr[]){
        this.n = arr.length;
        this.arr = arr;
        subList = new ArrayList<>();
        vis = new boolean[n];
        solve2(0);
    }
    
    void solve2(int idx){
        if(subList.size() == n){
            for(int ele : subList)
                System.out.print(ele + " ");
            System.out.println();
            return;
        }

        for(int i = idx; i < n; i++){
            subList.add(arr[i]);
            swap(i, idx);
            solve2(idx + 1);
            subList.remove(subList.size() - 1);
            swap(i, idx);
        }
    }

    void swap(int i, int  j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

