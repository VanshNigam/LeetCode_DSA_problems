class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int i = n - 1;
        while (i >= 0 && !set.contains(nums[i])) {
            set.add(nums[i]);
            i--;
        }

        int idx = i + 1;
        return (idx + 2) / 3;
    }
}