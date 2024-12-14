

// User function Template for Java

class ReverseAraay {
    void pushZerosToEnd(int[] arr) {
        // code here
        int p = 0;
        for(int i : arr){
            if(i!=0){
                arr[p++] = i; 
            }
        }
        for(int i = p;i<arr.length;i++){
            arr[i] = 0;
        }
    }
}
