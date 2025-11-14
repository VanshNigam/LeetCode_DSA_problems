class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt=Counter(nums)
        sorted_cnt=sorted(cnt,key=cnt.get,reverse=True)
        res=[]
        i=0
        for x in sorted_cnt:
            res.append(x)
            i+=1
            if i==k:
                break
        return res