import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int arr[] = new int[n];
      for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
      }

      Solution obj = new Solution();
      obj.generate(arr);
    }
}

class Solution{
  List<List<Integer>> ans;
  public void generate(int arr[]){
    int n = arr.length;
    ans = new ArrayList<>();
    List<Long> list = new ArrayList<>();
    int total = (1 << n) - 1;
    for(int mask = 1; mask <= total; mask++){
      List<Integer> sub = new ArrayList<>();
      long l = 1;
      for(int i = 0; i < n; i++){
        if((mask & (1 << i)) != 0){
          sub.add(arr[i]);
          l = lcm(l, arr[i]);
        }
      }
      ans.add(sub);
      list.add(l);
    }

    for(int i = 0; i < ans.size(); i++){
      for(int ele : ans.get(i))
        System.out.print(ele + " ");
      System.out.print("   LCM = " + list.get(i));
      System.out.println();
    }
  }

  public long lcm(long a, long b){
        long g = gcd(a, b);
        long p = 1L * a * b;
        return p / g;
    }

    public long gcd(long a, long b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}
