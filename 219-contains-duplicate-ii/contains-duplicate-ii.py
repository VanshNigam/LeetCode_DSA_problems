class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        hmap = {}
        for i in range(len(nums)):
            if nums[i] in hmap and i - hmap[nums[i]] <= k:
                return True
            hmap[nums[i]] = i
        return False
