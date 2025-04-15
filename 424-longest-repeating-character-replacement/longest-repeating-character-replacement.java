class Solution {
    public int characterReplacement(String s, int k) {
        int arr[]=new int[26];

        int l = 0;
        int r = 0;
        int n = s.length(), max = 0, maxFrq = 0;

        while (l < n && r < n) {
            arr[s.charAt(l)-'A']+=1;
            maxFrq = Math.max(maxFrq, arr[s.charAt(l)-'A']);

            int len = l - r + 1 - maxFrq;

            if (len > k) {
                arr[s.charAt(r)-'A']-=1;

                len = l - r + 1 - maxFrq;
                r+=1;
            }                 
            max = Math.max(max, l - r + 1);
            l+=1;
        }
        return max;
    }
}