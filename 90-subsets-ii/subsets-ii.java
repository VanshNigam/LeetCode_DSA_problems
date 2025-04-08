class Solution {
    Set<List<Integer>> st = new HashSet<>();

    public void help(int nums[], int i, List<Integer> lst) {
        if (i == nums.length) {
            // Collections.sort(lst);

            st.add(new ArrayList<>(lst));
            return;
        }
        lst.add(nums[i]);
        help(nums, i + 1, lst);

        lst.remove(lst.size() - 1);
        help(nums, i + 1, lst);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        help(nums, 0, new ArrayList<>());
        for (List<Integer> l : st) {
            ans.add(l);
        }
        return ans;
    }
}