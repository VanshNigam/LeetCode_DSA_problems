# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(node, max_so_far):
            if not node:
                return 0
            
            # Check if this is a "good node"
            good = 1 if node.val >= max_so_far else 0
            
            # Update the max value for the next path
            new_max = max(max_so_far, node.val)
            
            # Count good nodes from left and right children
            return good + dfs(node.left, new_max) + dfs(node.right, new_max)

        return dfs(root, float("-inf"))  # Start with the smallest possible value