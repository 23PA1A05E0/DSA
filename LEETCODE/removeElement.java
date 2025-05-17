class Solution {
    public int removeElement(int[] nums, int val) {
        int arr[] = new int[nums.length];
        int count = 0;
        int j=0;
        for(int i:nums){
            if(i!=val){
                arr[j] = i;
                j++;
            }
        }
        for(int i=0;i<j;i++){
            nums[i] = arr[i];
        }
        return j;
    }
}
