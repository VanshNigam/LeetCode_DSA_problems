//NOT BY ME
class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        if (k == 26) return 1;

        int[] p1 = new int[n], m1 = new int[n];
        int[] p2 = new int[n], m2 = new int[n];

        int p = 1, m = 0;
        for (int i = 0; i < n; i++) {
            int cm = 1 << (s.charAt(i) - 'a');
            if (Integer.bitCount(m | cm) > k) { p++; m = cm; } 
            else m |= cm;
            p1[i] = p; m1[i] = m;
        }

        p = 1; m = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cm = 1 << (s.charAt(i) - 'a');
            if (Integer.bitCount(m | cm) > k) { p++; m = cm; } 
            else m |= cm;
            p2[i] = p; m2[i] = m;
        }

        int ans = p2[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                int ncm = 1 << j;
                int pb = i > 0 ? p1[i-1] : 0, mb = i > 0 ? m1[i-1] : 0;
                int pa = i+1 < n ? p2[i+1] : 0, ma = i+1 < n ? m2[i+1] : 0;

                int cp, cmask;
                if (i == 0) { cp = 1; cmask = ncm; } 
                else if (Integer.bitCount(mb | ncm) > k) { cp = pb + 1; cmask = ncm; }
                else { cp = pb; cmask = mb | ncm; }

                int t = cp + pa;
                if (pa > 0 && Integer.bitCount(cmask | ma) <= k) t--;
                ans = Math.max(ans, t);
            }
        }
        return ans;
    }
}