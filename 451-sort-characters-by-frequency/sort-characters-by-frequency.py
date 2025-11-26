class Solution:
    def frequencySort(self, s: str) -> str:
        cnt=Counter(s)
        res=""
        sorted_cnt=sorted(cnt,key=cnt.get,reverse=True)
        for x in sorted_cnt:
            res+=x*cnt[x]
        return res
