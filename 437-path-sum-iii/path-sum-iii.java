class Solution {
    int c;
    Map<Long, Integer> mp;

    public void help(TreeNode r, int t, Long curr) {
        if (r == null)
            return;
        curr += r.val;
        c += mp.getOrDefault((curr - t), 0);

        mp.put(curr, mp.getOrDefault(curr, 0) + 1);
        help(r.left, t, curr);
        help(r.right, t, curr);

        mp.put(curr, mp.get(curr) - 1);
        if (mp.get(curr) == 0)
            mp.remove(curr);
    }

    public int pathSum(TreeNode root, int t) {
        mp = new HashMap<>();
        c = 0;
        mp.put(0l, 1);
        help(root, t, 0l);
        return c;
    }
}