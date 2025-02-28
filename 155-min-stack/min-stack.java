class MinStack {
    Stack<Integer>st=new Stack<>();
    Stack<Integer>min=new Stack<>();

    public MinStack() {}
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty())min.push(val);
        else {
            if(min.peek()>val)min.push(val);
            else min.push(min.peek());
        }
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {

        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */