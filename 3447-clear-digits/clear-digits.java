class Solution {

    public String clearDigits(String s) {
        int i = 0;
        int l = s.length();

        StringBuilder sb = new StringBuilder(s);
        while (i < sb.length()) {
            char ch = sb.charAt(i);
            if (Character.isDigit(ch)) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i - 1);
                i--;
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}