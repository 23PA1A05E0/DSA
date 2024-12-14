import java.util.*;
class InsertionSort{
	// Sort method
	public static void sort(int a[],int n){
		int i,j,key;
		for(i=1;i<n;i++){
			key = a[i];
			j = i-1;
			while(j>=0 && key<a[j]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
			
		}
		
		
	}
	
	//Display Method
	public static void display(int a[]){
		for(int i:a)
			System.out.print(i+" ");
	}
	
	// main Method
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Size of an array:");
		int n = sc.nextInt();
		System.out.print("Enter the "+n+" elements:");
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		System.out.print("Before sorting:");
		display(a);
		System.out.println();
		System.out.print("After sorting:");
		sort(a,n);
		display(a);
		System.out.println();
	}
}
