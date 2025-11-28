class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hmap={0:1}
        prefix=0
        res=0
        for num in nums:
            prefix+=num
            diff=prefix-k
            if diff in hmap:
                res+=hmap[diff]
            hmap[prefix]=1+hmap.get(prefix,0)
        print(hmap)        
        return res            
                