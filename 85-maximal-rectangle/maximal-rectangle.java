class Solution {
    public int largestHistogram(int[] arr) {
        int n = arr.length;
        int l[] = new int[n];
        int r[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if (st.isEmpty()) l[i] = -1;
            else l[i] = st.peek(); 
            st.push(i);
        }
        st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])  st.pop();
            if (st.isEmpty())  r[i] = n;
            else  r[i] = st.peek();
            st.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int curr = arr[i] * (r[i] - l[i] - 1);
            max = Math.max(max, curr);
        }
        return max;
    }

    public int maximalRectangle(char[][] mat) {
        int arr[] = new int[mat[0].length];
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == '0') arr[j] = 0;
                else  arr[j] += 1;
            }
            max = Math.max(max, largestHistogram(arr));
        }
        return max;
    }
}