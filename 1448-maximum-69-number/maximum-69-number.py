class Solution:
    def maximum69Number (self, num: int) -> int:
        s=str(num)
        ans=num
        for i in range(len(s)):
            if s[i]=="6":
                val=(int(s[:i]+"9"+s[i+1:]))
            else :
                val=(int(s[:i]+"6"+s[i+1:]))
            ans=max(val,ans)
        return ans