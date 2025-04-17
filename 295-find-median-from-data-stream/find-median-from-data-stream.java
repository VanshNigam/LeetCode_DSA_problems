class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> b - a);
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());

        if (max.size() < min.size()) {
            max.add(min.poll());
        }
    }

    public double findMedian() {
        double ans = 0;
        if (min.size() == max.size()) {
            ans += min.peek();
            ans += max.peek();
        } else {
            return (double) max.peek();
        }
        return ans / 2;
    }
}
