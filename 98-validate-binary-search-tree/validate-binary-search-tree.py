# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(node, elements):
            if not node:
                return
            inorder(node.left, elements)
            elements.append(node.val)
            inorder(node.right, elements)
        elements = []
        inorder(root, elements)
        for i in range(1, len(elements)):
            if elements[i] <= elements[i-1]:
                return False
        return True
        