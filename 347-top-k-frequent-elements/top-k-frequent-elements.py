class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt=Counter(nums)
        heap=[]
        i=0
        for x in cnt:
            heapq.heappush(heap,(cnt[x],x))
            if len(heap)>k:
                heapq.heappop(heap)
        res=[]
        for x in heap:
            res.append(x[1])
        return res
            