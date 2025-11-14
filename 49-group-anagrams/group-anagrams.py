class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hmap={}
        for x in strs:
            y=' '.join(sorted(x))
            if y not in hmap:
                hmap[y]=[x]
            else:
                hmap[y].append(x)
        res=[]
        for x in hmap:
            res.append(hmap[x])        
        return res