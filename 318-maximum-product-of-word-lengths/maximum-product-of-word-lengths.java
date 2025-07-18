class Solution {
    public boolean help(String a, String b) {
        boolean[] freq = new boolean[26];

        for (char c : a.toCharArray()) {
            freq[c - 'a'] = true;
        }

        for (char c : b.toCharArray()) {
            if (freq[c - 'a'])
                return true;
        }

        return false;
    }

    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!help(words[i], words[j]))
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}