
class Solution {
    public void help(TreeNode r, ArrayList<Integer> arr, int level) {
        if (r == null)
            return;
        if (level == arr.size())
            arr.add(r.val);
        help(r.right, arr, level + 1);
        help(r.left, arr, level + 1);
    }

    ArrayList<Integer> rightSideView(TreeNode root) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        help(root, arr, 0);
        return arr;
    }
}