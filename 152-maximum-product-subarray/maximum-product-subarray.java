class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;

        int pre =1;
        int suffix=1;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(pre==0)pre=1;
            if(suffix==0)suffix=1;

            pre=pre*nums[i];
            suffix=suffix*nums[n-i-1];

            max=Math.max(max,Math.max(pre,suffix));
        }
        return max;
    }
}