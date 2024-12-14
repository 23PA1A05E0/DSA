import java.util.*;
class SelectionSort{
	// Sort method
	public static void sort(int a[],int n){
		int i,j,min_index;
		for(i=0;i<n-1;i++){
			min_index = i;
			for(j=i+1;j<n;j++){
				if(a[min_index]>a[j]){
					min_index = j;
				}
			}
			if(min_index!=i){
				int temp = a[import java.util.*;
class SelectionSort{
	// Sort method
	public static void sort(int a[],int n){
		int i,j,min_index;
		for(i=0;i<n-1;i++){
			min_index = i;
			for(j=i+1;j<n;j++){
				if(a[min_index]>a[j]){
					min_index = j;
				}
			}
			if(min_index!=i){
				int temp = a[min_index];
				a[min_index] = a[i];
				a[i] = temp;
			}
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
}min_index];
				a[min_index] = a[i];
				a[i] = temp;
			}
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
