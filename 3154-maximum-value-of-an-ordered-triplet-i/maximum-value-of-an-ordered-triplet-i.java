class Solution {
    public long maximumTripletValue(int[] nums) {
        long max=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    max=Math.max((nums[i]-nums[j])*(long)nums[k],max);
                }
            }
        }
        return max;
    }
}