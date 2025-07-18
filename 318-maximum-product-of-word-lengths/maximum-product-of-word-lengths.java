class Solution {
    public int maxProduct(String[] words) {
        int arr[] = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                int bit = c - 'a';
                mask |= (1 << (c - 'a'));
            }
            arr[i] = mask;
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((arr[i] & arr[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}