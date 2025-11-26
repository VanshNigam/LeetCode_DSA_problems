class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        heap=[]
        cnt=Counter(nums)
        for num in cnt:
            heapq.heappush(heap,(cnt[num],num))
            if len(heap)>k:
                heapq.heappop(heap)
        res=[]
        for x in heap:
            res.append(x[1])
        return res
        