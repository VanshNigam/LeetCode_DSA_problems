class Solution {
    public boolean help(int i) {
        String s = i + "";
        if (s.length() % 2 != 0)
            return false;
        int left = 0;
        int right = 0;

        for (int x = 0; x < s.length() / 2; x++) {
            left += (int) s.charAt(x);
            right += (int) s.charAt(s.length() - x - 1);
        }
        return left == right;
    }

    public int countSymmetricIntegers(int low, int high) {
        int c = 0;
        for (int i = low; i <= high; i++) {
            if (help(i))
                c++;
        }
        return c;
    }
}