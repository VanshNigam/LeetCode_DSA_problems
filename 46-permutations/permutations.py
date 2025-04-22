class Solution(object):
    def permute(self, nums):
        def helper(idx):
            if(idx==len(nums)):
                res.append(nums[:])
                return 

            for i in range(idx,len(nums)):
                nums[i],nums[idx]=nums[idx],nums[i]
                helper(idx+1)
                nums[i],nums[idx]=nums[idx],nums[i]

        res=[]
        helper(0)
        return res
