class Solution {
    int count;
    String ans;

    public boolean backTrack(int n, int k, StringBuilder cur) {
        // base case
        if (n == cur.length()) {
            count++;
            if (count == k) {
                ans = cur.toString();
                return true;
            }
            return false;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            int l = cur.length();
            if (l > 0 && cur.charAt(l - 1) == ch)
                continue;
            cur.append(ch);
            if (backTrack(n, k, cur))
                return true;
            cur.deleteCharAt(l);
        }
        return false;
    }

    public String getHappyString(int n, int k) {
        count = 0;
        ans = "";
        backTrack(n, k, new StringBuilder(""));
        return ans;
    }
}