class Solution {

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Boolean> mp = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (mp.containsKey(k - t.val))
                    return true;
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
                mp.put(t.val,true);
            }
        }
        return false;
    }
}