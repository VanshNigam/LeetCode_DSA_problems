class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        //first check
        if(nums[0]>=nums[1])return false;
        int i=2;
        while(i<n && nums[i]>nums[i-1])i++;
        if(i==n)return false;

        //second check
        while(i<n && nums[i]<nums[i-1])i++;
        if(i==n)return false;

        //third check
        while(i<n && nums[i]>nums[i-1])i++;
        if(i!=n)return false;

        return true;
    }
}