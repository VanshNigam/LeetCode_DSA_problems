class Solution {
    public int search(int[] nums, int target) {
        int x=0;
        int y=nums.length-1;

        while(x<=y){
            int mid=(x+y)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]>target)y=mid-1;
            else x=mid+1;
        }
        return -1;
    }
}