# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        hashmap={}
        res=[]
        def dfs(root):
            if root is None:    
                return "N" 
            k= str(root.val)+','+dfs(root.left)+','+dfs(root.right) 
            if k in hashmap:
                hashmap[k]+=1
            else:
                hashmap[k]=0 
            if hashmap[k]==1:
                res.append(root)
            return k
        dfs(root)
        return res                          
           
            
           
        