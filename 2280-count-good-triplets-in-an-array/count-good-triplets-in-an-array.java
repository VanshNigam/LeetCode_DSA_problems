class Solution {
    class BIT {
    private int[] tree;
    private int n;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        public void update(int i, int delta) {
            i++;
            while (i <= n + 1) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        public int query(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }

        public int queryRange(int left, int right) {
            return query(right) - query(left - 1);
        }
    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }

        BIT prefixBIT = new BIT(n);
        int[] leftSmaller = new int[n];

        for (int i = 0; i < n; i++) {
            leftSmaller[i] = prefixBIT.query(mapped[i] - 1);
            prefixBIT.update(mapped[i], 1);
        }

        BIT suffixBIT = new BIT(n);
        int[] rightLarger = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightLarger[i] = suffixBIT.query(n - 1) - suffixBIT.query(mapped[i]);
            suffixBIT.update(mapped[i], 1);
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (long) leftSmaller[i] * rightLarger[i];
        }

        return count;
    }
}