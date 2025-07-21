class Solution {
    public String makeFancyString(String s) {
        StringBuilder res =new StringBuilder();
        int c = 0;
        char prev = s.charAt(0);
        for (char ch : s.toCharArray()) {
            // System.out.println(prev+""+c);
            if (ch == prev)
                c++;
            else {
                prev = ch;
                c = 1;
            }
            if (c >= 3) {
                continue;
            } else
                res.append(ch);
        }
        return res.toString();
    }
}