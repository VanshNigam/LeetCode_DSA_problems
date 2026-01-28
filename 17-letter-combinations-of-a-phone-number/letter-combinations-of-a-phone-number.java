class Solution {
    int n;
    List<String> ans;
    Map<Character, String> mp;

    public void help(String dig, int i, String s) {
        if (i >= n || s.length() == n) {
            ans.add(s);
            return;
        }
        Character num = dig.charAt(i);
        String temp = mp.get(num);

        for (char c : temp.toCharArray()) {
            s += c;
            help(dig, i + 1, s);

            s = s.substring(0, s.length() - 1);
        }
    }

    public List<String> letterCombinations(String dig) {
        n = dig.length();
        ans = new ArrayList<>();
        mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        help(dig, 0, "");
        return ans;
    }
}