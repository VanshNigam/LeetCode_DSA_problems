class Solution {
    public int maxDifference(String s) {
        int arr[] = new int[26];
        int even = Integer.MAX_VALUE, odd = 0;
        int odd2 = Integer.MAX_VALUE, even2 = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            arr[i]++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                if (arr[i] % 2 == 0) {
                    even = Math.min(even, arr[i]);
                    even2 = Math.max(even, arr[i]);
                } else {
                    odd = Math.max(odd, arr[i]);
                    odd2 = Math.min(odd, arr[i]);
                }
            }
        }
        int a = (odd) - (even);
        int b = odd2 - even2;
        int ans = a > b ? a : b;
        return ans;
    }
}