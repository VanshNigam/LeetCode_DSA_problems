
class Solution {
    public TreeNode help(int[] inorder, int is, int iend,
            int[] preorder, int ps, int pend, HashMap<Integer, Integer> mp) {
        if (is > iend || ps > pend)
            return null;

        TreeNode root = new TreeNode(preorder[ps]);

        int ind = mp.get(preorder[ps]);
        int devide = ind - is;

        root.left = help(inorder, is, ind - 1, preorder, ps + 1, ps + devide, mp);
        root.right = help(inorder, ind + 1, iend, preorder, ps + devide + 1, pend, mp);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mp = new HashMap<>();//inorder ki index

        for (int i = 0; i < inorder.length; i++)
            mp.put(inorder[i], i);
        return help(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, mp);
    }
}