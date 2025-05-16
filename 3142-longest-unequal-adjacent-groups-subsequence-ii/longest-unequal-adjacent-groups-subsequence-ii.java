class Solution {
    public int hamming(String a, String b) {
        if (a.length() != b.length())
            return -1;
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                c++;
        }
        return c;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] prevInd = new int[n];
        Arrays.fill(prevInd, -1);

        int maxLen = -1;
        int maxI = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] != arr[i] && hamming(words[i], words[j]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prevInd[i] = j;
                        if (dp[i] > maxLen) {
                            maxLen = dp[i];
                            maxI = i;
                        }
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>();
        while (maxI != -1) {
            ans.add(0, words[maxI]);
            maxI = prevInd[maxI];
        }

        return ans;
    }
}
