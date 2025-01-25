import java.util.*;
class MergeSort{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		Sort s = new Sort();
		System.out.printf("Enter the size of an Array:");
		int n = sc.nextInt();
		System.out.printf("Enter the %d elements in array:",n);
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		long st = System.nanoTime();
		System.out.printf("Before Sorting::");
		s.display(a);
		s.divide(a,0,n-1);
		long et = System.nanoTime();
		System.out.print("\nAfter Sorting::");
		s.display(a);
		System.out.println("\nTime duration:" + (et-st));
			
	}
}
//Sorting class
class Sort{
	public static void merge(int a[],int start,int mid,int end){
		int i = start;
		int j = mid+1;;
		int k = start;
		int b[] = new int[a.length];
		while(i<=mid && j<=end){
			if(a[i]<=a[j])
				b[k] = a[i++];
			else
				b[k] = a[j++];
			k++;
						
		}
		while(i<=mid)
			b[k++] = a[i++];
		while(j<=end)
			b[k++] = a[j++];
		for(i=start;i<=end;i++)
			a[i] = b[i];	
	}
	public void divide(int a[],int start,int end){
		if(start<end){
			int mid = (start + end)/2;
			divide(a,start,mid);
			divide(a,mid+1,end);
			merge(a,start,mid,end);
		}	
	}
	public void display(int a[]){
		for(int i:a)
			System.out.printf("%d ",i);
	}
}
