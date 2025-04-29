class Pair {
    TreeNode r;
    int i;

    public Pair(TreeNode r, int ind) {
        this.r = r;
        this.i = ind;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode r) {
        if (r == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, 0));
        int maximum = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            int minIndex = q.peek().i;
            int first = 0, last = 0;

            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                int curIndex = p.i - minIndex;

                if (i == 0) first = curIndex;
                if (i == n - 1) last = curIndex;

                if (p.r.left != null)
                    q.add(new Pair(p.r.left, 2 * curIndex + 1));
                if (p.r.right != null)
                    q.add(new Pair(p.r.right, 2 * curIndex + 2));
            }

            maximum = Math.max(maximum, last - first + 1);
        }

        return maximum;
    }
}
