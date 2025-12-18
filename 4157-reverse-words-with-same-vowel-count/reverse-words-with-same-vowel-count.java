class Solution {
    public int count(String x) {
        int count = 0;
        for (char c : x.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count++;
        }
        return count;
    }

    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        int c = count(arr[0]);

        s = arr[0];
        for (int i = 1; i < arr.length; i++) {
            s += " ";
            int vowel = count(arr[i]);
            if (vowel == c) {
                String rev = "";
                for (int j = arr[i].length() - 1; j >= 0; j--) {
                    rev += arr[i].charAt(j);
                }
                arr[i] = rev;
            }
            s += arr[i];
        }
        return s;
    }
}