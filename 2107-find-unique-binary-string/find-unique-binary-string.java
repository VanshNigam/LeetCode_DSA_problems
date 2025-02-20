class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str = new StringBuilder();
        int k = 0;

        for (String s : nums) {
            if (s.charAt(k) == '0') {
                str.append('1');
            } else {
                str.append('0');
            }
            k++;
        }
        return str.toString();
    }
}