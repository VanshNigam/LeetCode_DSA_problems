class Solution {
    List<String>arr=new ArrayList<String>();

    public void help(int open, int close, int n, String str) {
        if (open == n && close == n) {
            arr.add(str);
            return;
        }
        if (open < n) {
            help(open + 1, close, n, str + "(");
        }
        if (open > close) {
            help(open, close + 1, n, str + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
         help(0,0,n,"");
         return arr;
    }
}