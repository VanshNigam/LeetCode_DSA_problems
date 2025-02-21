class FindElements {
    Map<Integer, Integer> mp = new HashMap<>();

    public void help(TreeNode r) {
        if (r == null)
            return;

        int x = r.val;
        if (r.left != null) {
            r.left.val = 2 * x + 1;
            mp.put(r.left.val, 0);
        }
        if (r.right != null) {
            r.right.val = 2 * x + 2;
            mp.put(r.right.val, 0);
        }
        help(r.left);
        help(r.right);
    }

    public FindElements(TreeNode root) {
        if (root != null) {
            root.val = 0;
            mp.put(root.val, 0);
        }
        help(root);
    }

    public boolean find(int target) {
        return mp.containsKey(target);
    }
}