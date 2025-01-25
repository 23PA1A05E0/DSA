import java.util.*;

class QuickSort {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        Sort s = new Sort();
        System.out.printf("Enter the size of an Array:");
        int n = sc.nextInt();
        System.out.printf("Enter the %d elements in array:", n);
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        long st = System.nanoTime();
        System.out.printf("Before Sorting::");
        s.display(a);
        s.partition(a, 0, n - 1);
        long et = System.nanoTime();
        System.out.print("\nAfter Sorting::");
        s.display(a);
        System.out.println("\nTime duration(Nanosec):" + (et - st));
        System.out.println("\nTime duration(millisec):" + ((et - st)/1_00_000));
    }
}

class Sort {
    public int quick(int a[], int start, int end) {
        int i = start + 1;
        int j = end;
        int pivot = a[start];
        while (i <= j) {
            while (i <= j && a[i] <= pivot)
                i++;
            while (i <= j && a[j] >= pivot)
                j--;
            if (i < j)
                swap(a, i, j);
        }
        swap(a, start, j);
        return j;
    }

    public void partition(int a[], int start, int end) {
        if (start < end) {
            int j = quick(a, start, end);
            partition(a, start, j - 1);
            partition(a, j + 1, end);
        }
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void display(int a[]) {
        for (int i : a)
            System.out.printf("%d ", i);
    }
}
