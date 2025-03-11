class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // int[] arr = new int[2];
        // for (int i = 0; i < students.length; i++) {
        // arr[students[i]]++;
        // }
        // for (int j = 0; j < sandwiches.length; j++) {
        // if (arr[sandwiches[j]] > 0) {
        // arr[sandwiches[j]]--;
        // } else {
        // return arr[0] + arr[1];
        // }
        // }
        // return 0;

        /// ------3rd approach-----

        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i : students)
            q.add(i);
        for (int i = sandwiches.length - 1; i >= 0; i--)
            st.push(sandwiches[i]);
        int c = 0;

        while (!st.isEmpty() && c < st.size()) {
            if (q.peek() == st.peek()) {
                c = 0;
                st.pop();
                q.remove();
            } else {
                c++;
                int k = q.remove();
                q.add(k);
            }
        }
        return c;
    }
}