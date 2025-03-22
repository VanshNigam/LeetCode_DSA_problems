class Solution {
    public void del(TreeNode r, int k, TreeNode prev) {
        if (r == null) return;

        if (r.val == k) {
            if (r.left == null && r.right == null) { // No child
                if (prev != null) {
                    if (prev.left == r) prev.left = null;
                    else prev.right = null;
                }
            } else if (r.left != null && r.right == null) { // Only left child
                if (prev != null) {
                    if (prev.left == r) prev.left = r.left;
                    else prev.right = r.left;
                }
            } else if (r.right != null && r.left == null) { // Only right child
                if (prev != null) {
                    if (prev.left == r) prev.left = r.right;
                    else prev.right = r.right;
                }
            } else { // Two children
                TreeNode temp = r.right;
                while (temp.left != null) temp = temp.left;
                r.val = temp.val;
                del(r.right, temp.val, r);
            }
            return;
        }

        del(r.left, k, r);
        del(r.right, k, r);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        del(root, key, dummy);
        return dummy.left;
    }
}
