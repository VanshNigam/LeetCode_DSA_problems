
class Solution {
    int ans = 0;
    int c = 0;

    public void help(TreeNode r, int k) {
        if (r == null)
            return;
        help(r.left, k);
        c++;
        if (k == c) {
            ans = r.val;
            return;
        }
        help(r.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return ans;
    }
}