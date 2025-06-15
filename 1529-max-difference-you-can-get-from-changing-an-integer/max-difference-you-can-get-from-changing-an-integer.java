class Solution {
    public int maxDiff(int num) {
        String max = num + "";
        String min = num + "";
        char x = ' ';

        for (char c : max.toCharArray()) {
            if (c != '9') {
                x = c;
                break;
            }
        }
        max = max.replace(x, '9');

        if (min.charAt(0) != '1') {
            min = min.replace(min.charAt(0), '1');
        } else {
            for (int i = 1; i < min.length(); i++) {
                if (min.charAt(i) != '0' && min.charAt(i) != '1') {
                    min = min.replace(min.charAt(i), '0');
                    break;
                }
            }
        }
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}