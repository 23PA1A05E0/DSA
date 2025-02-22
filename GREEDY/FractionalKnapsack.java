import java.util.*;

class Item {
    int weight, value;
    double ratio;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {
    public static double maxvalue(Item items[], int m) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio)); // Sort by ratio in descending order
        double tvalue = 0.0; 

        for (Item item : items) {
            if (m == 0) break;

            if (m - item.weight >= 0) {
                m -= item.weight;
                tvalue += item.value;
            } else {
                tvalue += (item.ratio * m); 
                m = 0;
            }
        }


        return tvalue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the weight of bag:: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of objects:: ");
        int n = sc.nextInt();
        Item[] item = new Item[n]; 

        System.out.println("Enter the weight and value of each item::");
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();// Use %f for double
            int p = sc.nextInt();
            item[i] = new Item(w, p); 
        }

        double value = maxvalue(item, m);
        System.out.printf("Maximum value that can be put in the bag is:: %.3f%n", value); 

        sc.close(); 
    }
}
