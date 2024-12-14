class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int index = -1,i;
        for(i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index = i;
                break;
            }
        }
        if(index==-1){
            rev(arr,0,n-1);
        }
        else{
            for(i=n-1;i>index;i--){
                if(arr[index]<arr[i]){
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
            rev(arr,index+1,n-1);
        }
    }
    void rev(int arr[],int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
