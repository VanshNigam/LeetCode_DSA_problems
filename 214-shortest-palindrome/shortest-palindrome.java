class Solution {
    public int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        String temp = s + "-" + rev;

        int arr[] = computeLPS(temp);
        int maxMatch = arr[temp.length() - 1];

        String rem = rev.substring(0, n - maxMatch);
        return rem + s;
    }
}