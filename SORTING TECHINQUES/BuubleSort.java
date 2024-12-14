import java.util.*;
class BubbleSort{

  //sorting function
	public static void sort(int a[],int n){
		int i,j,temp;
	    	for(i=0;i<n-1;i++){
			for(j=0;j<n-i-1;j++){
				if(a[j]>a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;	
					}	
				}	
			}
	}
  //display function
	public static void display(int a[]){
		for(int i:a)
			System.out.print(i+" ");
	}
	
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
