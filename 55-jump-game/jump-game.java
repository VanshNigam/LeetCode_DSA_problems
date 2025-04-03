class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int fuel = nums[0];
        fuel--;

        for (int i = 1; i < nums.length; i++) {
            System.out.println(fuel);
            if (fuel < 0)
                return false;
            fuel--;
            fuel = Math.max(nums[i] - 1, fuel);
        }

        return true;

    }
}