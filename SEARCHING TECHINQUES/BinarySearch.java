import java.util.*;
class BinarySearch{
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
	//Search Function
	public static int search(int a[],int n,int key){
		int start=0,end=n-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(a[mid]==key)
				return mid+1;	
			
			else if(key>a[mid])
				start = mid+1;
			
			else
				end = mid-1;	
		}
		return -1;
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
		System.out.print("Enter the element to search:");
		int key = sc.nextInt();
		int pos = search(a,n,key);
		if(pos==-1)
			System.out.println("Element is not found!");
		else
			System.out.printf("Element is found at position %d\n",pos);			
	}
}
