class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();

        int l = 0;
        int r = 0;
        int n = s.length(), max = 0, maxFrq = 0;

        while (l < n && r < n) {
            mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l), 0) + 1);
            maxFrq = Math.max(maxFrq, mp.get(s.charAt(l)));

            int len = l - r + 1 - maxFrq;

            if (len > k) {
                mp.put(s.charAt(r), mp.get(s.charAt(r)) - 1);
                if (mp.get(s.charAt(r)) == 0) {
                    mp.remove(s.charAt(r));
                }
                len = l - r + 1 - maxFrq;
                r++;
            }                 
            max = Math.max(max, l - r + 1);
            l++;
        }
        return max;
    }
}