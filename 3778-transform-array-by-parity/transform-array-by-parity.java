class Solution {
    public int[] transformArray(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0)nums[i]=0;
            else nums[i]=1;
        }
        Arrays.sort(nums);
        return nums;
    }
}