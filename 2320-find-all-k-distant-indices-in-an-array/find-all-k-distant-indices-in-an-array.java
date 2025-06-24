class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        HashMap<Integer, Integer> mp = new HashMap();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = Math.max(i - k, 0); j <= Math.min(nums.length - 1, i + k); j++) {
                    if (!mp.containsKey(j))
                        ans.add(j);
                    mp.put(j, 1);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}