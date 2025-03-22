import java.util.*;
public class MaxHeap{
    static int maxSize,heapSize,temp;
    static int arr[];
    public MaxHeap(int ms){
        maxSize = ms;
        heapSize = 0;
        arr = new int[maxSize];
    }
    public static int parent(int i){
        return (i-1)/2;
    }
    public static int lchild(int i){
        return (2*i + 1);
    }
    public static int rchild(int i){
        return (2*i +2);
    }
    public static void maxHeapify(int i){
        int l = lchild(i);
        int r = rchild(i);
        int max = i;
        if(l<heapSize && arr[l]>arr[max])
            max = l;
        if(r<heapSize && arr[r]>arr[max])
            max = r;
        if(max!=i){
           temp = arr[max];
           arr[max] = arr[i];
           arr[i] = temp; 
           maxHeapify(max);
        }      
    }

    public static void insert(int x){
        if(heapSize==maxSize){
            System.out.println("Can't insert");
            return;
        }
        int i = heapSize;
        arr[i] = x;
        heapSize++;
        while(i!=0 && arr[i]>arr[parent(i)]){
            temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i =parent(i);
        }
    }
    public static void removeMax(){
        arr[0] = arr[heapSize-1];
        heapSize--;
        maxHeapify(0);
    }
    public static int getMax(){
        return arr[0];
    }
    public static int getSize(){
        return heapSize;
    }
    public static void display(){
        if(heapSize==0){
            System.out.println("Heap is empty");
            return;
        }
        else{
            for(int i=0;i<heapSize;i++)
                System.out.printf("%d ",arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of a Heap::");
        int size = sc.nextInt();
        MaxHeap mh = new MaxHeap(size);
        int opt,key;
        do{
            
            System.out.println("1-insert 2-delete 3-display 4-removeMax 5- getSize 6-getMax 7-exit");
            opt = sc.nextInt();
            switch (opt) {
                case 1: System.out.print("Enter the element:");
                        key = sc.nextInt();
                        insert(key);
                        break;
                case 2: System.out.print("Enter the element to delete");
                        key = sc.nextInt();
                        break;
                case 3: display(); 
                        System.out.println();
                        break;
                case 4: removeMax();
                        break;
                case 5: System.out.println("Size= " + getSize());
                        break;
                case 6: System.out.println("Maximum element is " + getMax()); 
                        break;
                case 7 : System.out.println("exists...."); 
                         break;
                default: System.out.println("Enter the valid option");
                          break;
            }
        }
        while (opt!=7) ;
            
        
    }
}
