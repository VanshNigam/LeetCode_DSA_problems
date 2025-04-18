class Solution {
    public String help(int n) {
        if (n == 1)
            return "1";

        String prev = help(n - 1);
        StringBuilder ans = new StringBuilder();
        char p = prev.charAt(0);
        int c = 1;

        for (int i = 1; i < prev.length(); i++) {
            if (p == prev.charAt(i))
                c++;
            else {
                ans.append(c);
                ans.append(p);
                c = 1;
                p = prev.charAt(i);
            }
        }
        if (c != 0) {
            ans.append(c);
            ans.append(p);
        }
        return ans.toString();
    }

    public String countAndSay(int n) {
        return help(n);
    }
}