class Solution {
    Map<String, Boolean> mp;

    public boolean help(String s, int i, Boolean dp[]) {
        if (i == s.length()) return true;
        if (i > s.length()) return false;
        if (dp[i] != null) return dp[i];

        for (int x = i + 1; x <= s.length(); x++) {
            if (mp.containsKey(s.substring(i, x)) && help(s, x, dp)) {
                return dp[i]= true;
            }
        }
        return dp[i]=false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        mp = new HashMap<>();
        for (String x : wordDict) mp.put(x, true);
        Boolean dp[] = new Boolean[s.length() + 1];

        return help(s, 0, dp);
    }
}