class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev=-1;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]==1){
            if(prev==-1){
                prev=i;
            }
            else {
                if((i-prev)<=k)return false;
                prev=i;
            }
            }

        }
        return true;
    }
}