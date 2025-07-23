class Solution {
    public int maximumGain(String s, int x, int y) {
        char a = 'a';
        char b = 'b';
        if(y > x) {
            char temp = a;
            a = b; b = temp;
            int tempInt = x;
            x = y; y = tempInt;
        }
        
        int score = 0;
        Stack<Character> forwardStack = new Stack<>();
        for (char ch : s.toCharArray())
            if(!forwardStack.isEmpty() && ch == b && forwardStack.peek() == a) {
                score += x;
                forwardStack.pop();
            }
            else forwardStack.push(ch);
        
        Stack<Character> reverseStack = new Stack<>();
        while (!forwardStack.isEmpty())
            if(!reverseStack.isEmpty() && reverseStack.peek() == a && forwardStack.peek() == b) { 
                score += y;
                forwardStack.pop();
                reverseStack.pop();
            } else reverseStack.push(forwardStack.pop());

        return score; 
    }
}