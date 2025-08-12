class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def quick(nums, k):
            if not nums:
                return
            pivot = random.choice(nums)
            left = [x for x in nums if (x > pivot)]
            mid = [x for x in nums if (x == pivot)]
            right = [x for x in nums if (x < pivot)]

            l, m = len(left), len(mid)
            if k <= l:
                return self.findKthLargest(left, k)
            elif k > l + m:
                return self.findKthLargest(right, k - l - m)
            else:
                return mid[0]

        return quick(nums, k)
