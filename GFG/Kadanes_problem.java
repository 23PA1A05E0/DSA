class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        int current_max = arr[0];
        int global_max = arr[0];
        for(int i=1;i<arr.length;i++){
            current_max = Math.max(arr[i],current_max+arr[i]);
            if(current_max>global_max){
                global_max = current_max;
            }
        }
        return global_max;
    }
}
