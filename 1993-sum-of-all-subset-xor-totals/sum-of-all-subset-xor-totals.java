class Solution {
    public int help(int nums[],int i ,int xor){
        if(i==nums.length)return xor;
        int take=help(nums,i+1,xor^nums[i]);
        int nottake=help(nums,i+1,xor);
        return take+nottake;
    }
    public int subsetXORSum(int[] nums) {
        return help(nums,0,0);
    }
}