import java.util.*;
class LinearSearch{
	
	//Display Method
	public static void display(int a[]){
		for(int i:a)
			System.out.print(i+" ");
	}
	//Search Method
	public static int search(int a[],int n,int key){
		int i,pos=-1;
		for(i=0;i<n;i++){
			if(a[i]==key){
				pos =i+1;
				return pos;
			}
		}
		return -1;
		
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
		
		display(a);
		System.out.print("\nEnter the element to search:");
		int key = sc.nextInt();
		int pos = search(a,n,key);
		if(pos==-1){
			System.out.println("Element is not Found!");
		}
		
		else{
			System.out.println("Element is found at position "+pos);
		}
		
	}
}
