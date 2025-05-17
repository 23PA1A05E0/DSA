class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map <Integer,Integer> m = new HashMap<>();
       for(int i=0;i<nums.length;i++){
        int complement = target - nums[i];
        if(m.containsKey(complement)){
            return new int[]{i,m.get(complement)};
        }
        m.put(nums[i],i);
       }
       return new int[]{};
    }
}
