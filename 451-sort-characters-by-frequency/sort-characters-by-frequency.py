class Solution:
    def frequencySort(self, s: str) -> str:
        cnt=Counter(s)
        res=""
        cnt_sorted=sorted(cnt,key=cnt.get,reverse=True)
        print(cnt,cnt_sorted)
        for x in cnt_sorted:
            res+=x*cnt[x]
        return res        
        