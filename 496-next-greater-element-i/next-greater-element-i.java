class Solution {
    public int[] nextGreaterElement(int[] nums, int[] arr) {
        int m = nums.length;
        int n = arr.length;

        int ans[] = new int[m];
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < arr[i])
                st.pop();
            if (st.isEmpty())
                mp.put(arr[i], -1);
            else
                mp.put(arr[i], st.peek());

            st.push(arr[i]);
        }

        for (int i = 0; i < m; i++)
            ans[i] = mp.get(nums[i]);
        return ans;
    }
}