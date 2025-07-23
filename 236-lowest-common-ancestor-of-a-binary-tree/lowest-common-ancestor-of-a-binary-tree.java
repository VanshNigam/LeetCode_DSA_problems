class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> que = new LinkedList<>();
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        Map<TreeNode, TreeNode> mp = new HashMap<>();
        que.add(root);
        mp.put(root, null);//parent save 

        while (!que.isEmpty()) {
            TreeNode x = que.poll();
            if (x.left != null) {
                que.add(x.left);
                mp.put(x.left, x);
            }
            if (x.right != null) {
                que.add(x.right);
                mp.put(x.right, x);
            }
        }
        while (p != null) {
            l1.add(p);
            p = mp.get(p);
        }
        while (q != null) {
            l2.add(q);
            q = mp.get(q);
        }
        Collections.reverse(l1);
        Collections.reverse(l2);

        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size() && l1.get(i) == l2.get(j)) {
            i++;
            j++;
        }
        return l1.get(i - 1);
    }
}