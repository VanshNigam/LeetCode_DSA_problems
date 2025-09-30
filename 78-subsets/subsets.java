class Solution {
    ArrayList<List<Integer>> a = new ArrayList<>();

    public void help(int nums[], int i, List<Integer> curr) {
        if (i >= nums.length) {
            a.add(new ArrayList<>(curr));
            return;
        }
        help(nums, i + 1, curr);
        curr.add(nums[i]);

        help(nums, i + 1, curr);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        help(nums, 0, new ArrayList<>());
        return a;
    }
}