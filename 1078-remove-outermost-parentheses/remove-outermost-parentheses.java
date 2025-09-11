class Solution {
    public String removeOuterParentheses(String s) {
        int open=0;
        String ans="";
        for(char ch:s.toCharArray()){
            if(ch==')')open--;
            if(open!=0)ans+=ch;
            if(ch=='(')open++;
        }
        return ans;
    }
}