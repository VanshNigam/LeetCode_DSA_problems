class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        curr=root
        while curr:
            if curr.left:
                pre=curr.left
                while pre.right:
                    pre=pre.right
                pre.right=curr.right
                curr.right=curr.left
                curr.left=None
            curr=curr.right


        