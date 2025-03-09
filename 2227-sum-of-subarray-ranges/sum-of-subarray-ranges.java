class Solution {
    // Find left min
    static void findleftmin(int[] leftmin, int[] nums, Stack<Integer> st) {
        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            while (!st.isEmpty() && elem <= nums[st.peek()]) {
                st.pop();
            }
            leftmin[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        st.clear();
    }

    // Find right min
    static void findrightmin(int[] rightmin, int[] nums, Stack<Integer> st) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int elem = nums[i];
            while (!st.isEmpty() && elem < nums[st.peek()]) {
                st.pop();
            }
            rightmin[i] = st.isEmpty() ? nums.length - i : st.peek() - i;
            st.push(i);
        }
        st.clear();
    }

    // Find left max
    static void findleftmax(int[] leftmax, int[] nums, Stack<Integer> st) {
        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            while (!st.isEmpty() && elem >= nums[st.peek()]) {
                st.pop();
            }
            leftmax[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        st.clear();
    }

    // Find right max
    static void findrightmax(int[] rightmax, int[] nums, Stack<Integer> st) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int elem = nums[i];
            while (!st.isEmpty() && elem > nums[st.peek()]) {
                st.pop();
            }
            rightmax[i] = st.isEmpty() ? nums.length - i : st.peek() - i;
            st.push(i);
        }
        st.clear();
    }

    public long subArrayRanges(int[] nums) {
        long minsum = 0;
        long largesum = 0;
        int leftmin[] = new int[nums.length];
        int rightmin[] = new int[nums.length];
        int leftmax[] = new int[nums.length];
        int rightmax[] = new int[nums.length];

        Stack<Integer> st = new Stack<>();
        
        findleftmin(leftmin, nums, st);
        findrightmin(rightmin, nums, st);
        
        for (int i = 0; i < nums.length; i++) {
            minsum = minsum + ((long)leftmin[i] * rightmin[i] * nums[i]);
        }
        
        findleftmax(leftmax, nums, st);
        findrightmax(rightmax, nums, st);
        
        for (int i = 0; i < nums.length; i++) {
            largesum = largesum + ((long)leftmax[i] * rightmax[i] * nums[i]);
        }

        return largesum - minsum;
    }
}