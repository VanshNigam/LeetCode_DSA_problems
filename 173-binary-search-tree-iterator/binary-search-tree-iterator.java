class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        TreeNode x = root;
        while (x != null) {
            st.push(x);
            x = x.left;
        }
    }

    public int next() {
        TreeNode pop = st.pop();
        TreeNode x = pop.right;
        while (x != null) {
            st.push(x);
            x = x.left;
        }
        return pop.val;
    }

    public boolean hasNext() {
        return st.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */