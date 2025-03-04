class FreqStack {
    Map<Integer, Integer> frq = new HashMap<>();
    Map<Integer, Stack<Integer>> st_each_freq = new HashMap<>();
    int maxfr = 0;

    public FreqStack() {
    }

    public void push(int val) {
        int f = frq.getOrDefault(val, 0) + 1;
        frq.put(val, f);

        maxfr = Math.max(f, maxfr);
        if (!st_each_freq.containsKey(f))
            st_each_freq.put(f, new Stack<>());
        st_each_freq.get(f).add(val);
    }

    public int pop() {
        int max = st_each_freq.get(maxfr).pop();
        frq.put(max, maxfr - 1);
        if (st_each_freq.get(maxfr).size() == 0)
            maxfr--;
        return max;
    }
}
