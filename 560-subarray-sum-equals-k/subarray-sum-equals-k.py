class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix=0
        hmap={0:1}
        res=0
        for i in range(len(nums)):
            prefix+=nums[i]
            diff=prefix-k
            if diff in hmap:
                res+=hmap[diff]
            hmap[prefix]=1+hmap.get(prefix,0)
        return res