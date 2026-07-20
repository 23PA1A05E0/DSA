import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            Solution obj = new Solution();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    mat[i][j] = sc.nextInt();
                }
            }
            List<List<Integer>> ans = new ArrayList<>();
            System.out.println("--------VALUE PATH----------");
            ans = obj.valuePath(mat);
            for(List<Integer> row : ans){
                for(int cell : row)
                    System.out.print(cell + " ");
                System.out.println();
            }
            System.out.println();

            System.out.println("--------EDGE PATH----------");
            obj.edgePath(mat);
        }
    }
}



class Solution{

    List<Character> sub;
    
    public void edgePath(int mat[][]){
        n = mat.length;
        m = mat[0].length;
        this.mat = mat;
        sub = new ArrayList<>();
        boolean vis[][] = new boolean[n][m];
        solve2(0, 0);
    }

    public void solve2(int i, int j){
        if(mat[i][j] < 0)
            return;
        
        if(i == n - 1 && j == m - 1){
           for(char ch : sub)
               System.out.print(ch + " ");
            System.out.println();
            return;
        }
        if(i + 1 < n){
            sub.add('D');
            solve2(i + 1, j);
            sub.remove(sub.size() - 1);
        }
        if(j + 1 < m){
            sub.add('R');
            solve2(i, j + 1);
            sub.remove(sub.size() - 1);
        }
    }















    
    List<List<Integer>> ans;
    int n;
    int m;
    List<Integer> subList;
    int mat[][];
    public List<List<Integer>> valuePath(int mat[][]){
        n = mat.length;
        m = mat[0].length;
        this.mat = mat;
        ans = new ArrayList<>();
        subList = new ArrayList<>();
        boolean vis[][] = new boolean[n][m];
        solve(0, 0);
        return ans;
    }









    
    public void solve(int i, int j){
        if(i >= n || j >= m)
            return;
        if(mat[i][j] < 0)
            return;
    
        subList.add(mat[i][j]);
        
        //System.out.printf("Path i = %d, j = %d, m[i][j] = %d\n", i, j, mat[i][j]);
        
        if(i == n - 1 && j == m - 1){
            ans.add(new ArrayList<>(subList));
            subList.remove(subList.size() - 1);
            return;
        }
        solve(i + 1, j);
        solve(i, j + 1);
        subList.remove(subList.size() - 1);
    }
}

