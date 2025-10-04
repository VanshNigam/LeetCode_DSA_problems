class Solution {
    Map<String, Boolean> mp;
    List<String> ans;

    public void help(String s, int i, String curr) {
        if (i == s.length()) {
            ans.add(curr.trim());
            return ;
        }
        if (i > s.length()) return ;

        for (int x = i + 1; x <= s.length(); x++) {
            if (mp.containsKey(s.substring(i, x))) {
                String sub = s.substring(i, x);
                help(s, x,curr + sub + " ");
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        mp = new HashMap<>();
        ans = new ArrayList<>();

        for (String x : wordDict)
            mp.put(x, true);

        help(s, 0, "");
        return ans;
    }
}