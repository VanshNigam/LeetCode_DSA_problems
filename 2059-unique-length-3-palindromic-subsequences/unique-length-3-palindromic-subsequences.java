class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        int[] firstOccurrence = new int[26];
        int[] lastOccurrence = new int[26];

        // Initialize firstOccurrence to -1
        Arrays.fill(firstOccurrence, -1);

        // Find the first and last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (firstOccurrence[index] == -1) {
                firstOccurrence[index] = i;
            }
            lastOccurrence[index] = i;
        }

        // Iterate through each character to count unique palindromic subsequences
        for (int i = 0; i < 26; i++) {
            if (firstOccurrence[i] == -1 || firstOccurrence[i] == lastOccurrence[i]) {
                continue; 
            }

            // Track unique characters between first and last occurrence
            boolean[] seen = new boolean[26];
            for (int j = firstOccurrence[i] + 1; j < lastOccurrence[i]; j++) {
                seen[s.charAt(j) - 'a'] = true;
            }

            // Count the unique characters
            for (boolean isSeen : seen) {
                if (isSeen) {
                    count++;
                }
            }
        }

        return count;
    }
}
