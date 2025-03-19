import java.util.*;
public class MergeSortDemo{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the " + n + " Elements");
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        System.out.print("Before Sorting::");
        for(int i:a)
            System.out.print(i + " ");
        mergeSort(a,0,a.length-1);
        System.out.print("\nAfter Sorting::");
        for(int i:a)
            System.out.print(i + " ");
        sc.close();
    }
    
    public static void mergeSort(int a[],int low,int high){
        if(low>=high)
            return;
        int mid = low + (high - low)/2;
        mergeSort(a,low,mid);
        mergeSort(a,mid+1,high);
        merge(a,low,mid,high);
    }
    
    public static void merge(int a[],int low,int mid,int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i=0;i<n1;i++){
            left[i] = a[low + i];
        }
        for(int j=0;j<n2;j++)
            right[j] = a[mid + 1 + j];
        int i=0,j=0,k = low;
        while(i<n1 && j<n2){
            if(left[i]<=right[j])
                a[k] = left[i++];
            else
                a[k] = right[j++];
            k++;
        }
        while(i<n1)
            a[k++] = left[i++];
        while(j<n2)
            a[k++] = right[j++];
    }
}
