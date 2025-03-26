import java.util.*;

public class MinHeap {
    static int maxSize, heapSize, temp;
    static int arr[];

    public MinHeap(int ms) {
        maxSize = ms;
        heapSize = 0;
        arr = new int[maxSize];
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static int lchild(int i) {
        return (2 * i + 1);
    }

    public static int rchild(int i) {
        return (2 * i + 2);
    }

    public static void minHeapify(int i) {
        int l = lchild(i);
        int r = rchild(i);
        int min = i;
        if (l < heapSize && arr[l] < arr[min])
            min = l;
        if (r < heapSize && arr[r] < arr[min])
            min = r;
        if (min != i) {
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            minHeapify(min);
        }
    }

    public static void insert(int x) {
        if (heapSize == maxSize) {
            System.out.println("Can't insert");
            return;
        }
        int i = heapSize;
        arr[i] = x;
        heapSize++;
        while (i != 0 && arr[i] < arr[parent(i)]) {
            temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

    public static void removeMin() {
        arr[0] = arr[heapSize - 1];
        heapSize--;
        minHeapify(0);
    }

    public static int getMin() {
        return arr[0];
    }

    public static int getSize() {
        return heapSize;
    }

    public static void display() {
        if (heapSize == 0) {
            System.out.println("Heap is empty");
            return;
        } else {
            for (int i = 0; i < heapSize; i++)
                System.out.printf("%d ", arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of a Heap::");
        int size = sc.nextInt();
        MinHeap mh = new MinHeap(size);
        int opt, key;
        do {
            System.out.println("1-insert 2-display 3-removeMin 4-getSize 5-getMin 6-exit");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Enter the element:");
                    key = sc.nextInt();
                    insert(key);
                    break;
                case 2:
                    display();
                    System.out.println();
                    break;
                case 3:
                    removeMin();
                    break;
                case 4:
                    System.out.println("Size= " + getSize());
                    break;
                case 5:
                    System.out.println("Minimum element is " + getMin());
                    break;
                case 6:
                    System.out.println("exits....");
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        } while (opt != 6);
    }
}
