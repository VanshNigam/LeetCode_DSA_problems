class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def height(root):
            if not root:
                return 0
            return 1 + max(height(root.left), height(root.right))
        if not root:
            return True
        return (
            (abs(height(root.left) - height(root.right)) < 2)
            and self.isBalanced(root.left)
            and self.isBalanced(root.right)
        )
