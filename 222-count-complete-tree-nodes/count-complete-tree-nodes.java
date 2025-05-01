
class Solution {
    public int right(TreeNode r) {
        int height = 0;
        while (r != null) {
            height++;
            r = r.right;
        }
        return height;
    }

    public int left(TreeNode r) {
        int height = 0;
        while (r != null) {
            height++;
            r = r.left;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        int nodes = 0;
        //nodes = 2^n -1 //complete tree
        if (root == null)
            return 0;
        int l = left(root.left);
        int r = right(root.right);

        if (l == r)
            return (2 << l) - 1;

        else
            return countNodes(root.left) + countNodes(root.right) + 1;

    }
}