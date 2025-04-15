class Solution {
    public String smallestPalindrome(String s) {
        // PriorityQueue<

        int arr[] = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        String start = "";
        String mid = "";

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            for (int x = 0; x < arr[i] / 2; x++) {
                start = start + c;
            }
            if (arr[i] % 2 != 0) {
                mid = c + "";
            }
        }
        StringBuilder end = new StringBuilder(start);
        end.reverse();

        return start + mid + end;
    }
}