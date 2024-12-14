class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        ArrayList<Integer> a = new ArrayList<>();
        int i,j,count,ele;
        int n = nums.length;
        boolean counted[] = new boolean[n];
        for(i=0;i<n;i++){
            ele = nums[i];
            count = 0;
            if(!counted[i]){
                for(j=0;j<n;j++){
                    if(ele==nums[j]){
                        count++;
                        counted[j] = true;
                    }
                }
                if(count>(n/3)){
                    a.add(ele);
                }
            }
        }
        Collections.sort(a);
        return a;
    }
}
