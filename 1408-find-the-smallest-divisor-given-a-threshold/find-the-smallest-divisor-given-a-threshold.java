class Solution {
    public static long divisorSum(int[] nums, int divisor){
        int n = nums.length;
        long sum = 0;
        for(int i = 0; i < n ; i++){
            // sum += Math.ceil((double)nums[i] / divisor);
            long div = (nums[i] + (divisor - 1)) / divisor;
            sum += div;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        // int high = Integer.MIN_VALUE;
        // for(int i =0; i< n; i++){
        //     if(nums[i] > high) high = nums[i];
        // }
        int high = (int)1e6;

        while(low <= high){
            int mid = low + (high - low) / 2;
            long sum = divisorSum(nums, mid);
            if(sum > threshold) low = mid + 1;
            else high = mid -1;
        }
        return low;
    }
}