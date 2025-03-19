class Solution {
    public int minOperations(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0){c++;
                for(int k=0;k<3;k++){
                    nums[i+k]=nums[i+k]==1?0:1;
                }
            }
        }
        if(nums[nums.length-2]==1 && nums[nums.length-1]==1)return c;
        return -1;
    }
}