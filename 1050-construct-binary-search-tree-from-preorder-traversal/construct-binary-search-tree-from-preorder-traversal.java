class Solution {
    public TreeNode help(int[] pre, int max, int[] ind) {
        if (ind[0] >= pre.length || pre[ind[0]] > max)
            return null;

        TreeNode root = new TreeNode(pre[ind[0]++]);
        root.left = help(pre, root.val, ind);
        root.right = help(pre, max, ind);
        return root;
    }

    public TreeNode bstFromPreorder(int[] pre) {
        int[] ind = {0}; // wrapper for index
        return help(pre, Integer.MAX_VALUE, ind);
    }
}
