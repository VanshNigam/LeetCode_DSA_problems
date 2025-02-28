class MyQueue {
    Stack<Integer>st=new Stack<>();
    public MyQueue() { }
    
    public void push(int x) {
        Stack<Integer>st2=new Stack<>();
        while(!st.isEmpty()){
            int t=st.pop();
            st2.push(t);
        }
        st.push(x);
        while(!st2.isEmpty()){
            int t=st2.pop();
            st.push(t);
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */