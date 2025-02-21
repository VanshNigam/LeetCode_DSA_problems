class FindElements {
    Map<Integer, Integer> mp = new HashMap<>();

    public void pre(TreeNode r) {
        if (r == null)
            return;

        mp.put(r.val, 0);
        pre(r.left);
        pre(r.right);
    }

    public void help(TreeNode r) {
        if (r == null)
            return;

        int x = r.val;
        if (r.left != null)
            r.left.val = 2 * x + 1;
        if (r.right != null)
            r.right.val = 2 * x + 2;

        help(r.left);
        help(r.right);
    }

    public FindElements(TreeNode root) {
        if (root != null)
            root.val = 0;
        help(root);
        pre(root);
    }

    public boolean find(int target) {
        return mp.containsKey(target);
    }
}