class Solution {

    public void help(Map<Integer, Integer> mp, List<List<Integer>> lst, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            lst.add(new ArrayList<>(curr));
            return;
        }
        for (int i : nums) {
            if (!mp.containsKey(i)) {
                curr.add(i);
                mp.put(i, 0);

                help(mp, lst, curr, nums);

                curr.remove(curr.size() - 1);
                mp.remove(i);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        help(mp, lst, new ArrayList<>(), nums);

        return lst;
    }
}