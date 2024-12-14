class SecondLargest {
    public int getSecondLargest(int[] arr) {
        // Code Here
         if (arr.length < 2) { 
             return -1;
        } // Not enough elements to determine the second largest } 
        
         int max = Integer.MIN_VALUE; 
         int sec_max = Integer.MIN_VALUE;
         
         for (int i = 0; i < arr.length; i++) { 
             if (arr[i] > max) { 
                 sec_max = max; 
                 max = arr[i]; 
             } 
             else if (arr[i] > sec_max && arr[i] != max) 
             {
                 sec_max = arr[i]; 
             } 
             
         } // If sec_max remains Integer.MIN_VALUE, it means there was no second largest element 
         if (sec_max == Integer.MIN_VALUE) { 
             return -1; 
             
         } 
         else { 
             return sec_max; 
             
         }
    }
}
