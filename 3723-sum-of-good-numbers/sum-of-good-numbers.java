class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean flag1 = false;
            boolean flag2 = false;
            if (i - k >= 0) {
                if (nums[i] > nums[i - k])
                    flag1 = true;
            } else {
                flag1 = true;
            }
            if (i + k < nums.length) {
                if (nums[i] > nums[i + k])
                    flag2 = true;
            } else {
                flag2 = true;
            }
            if (flag2 && flag1)
                sum += nums[i];
        }
        return sum;
    }
}