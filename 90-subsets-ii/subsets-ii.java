class Solution {
    public void help(int[] nums, int ind, List<Integer> curr, List<List<Integer>> lst) {
        lst.add(new ArrayList<>(curr));

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            
            help(nums, i + 1, curr, lst);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);

        help(nums, 0, curr, lst);
        return lst;
    }
}
