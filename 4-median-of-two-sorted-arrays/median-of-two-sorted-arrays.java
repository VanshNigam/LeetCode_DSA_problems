class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if (n > m)
            return findMedianSortedArrays(arr2, arr1);

        int low = 0;
        int high = n;

        int left = (n + m + 1) / 2;

        while (low <= high) {
            int mid = (low + high) >> 1;

            int mid2 = left - mid;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid < n)
                r1 = arr1[mid];
            if (mid2 < m)
                r2 = arr2[mid2];

            if (mid - 1 >= 0)
                l1 = arr1[mid - 1];
            if (mid2 - 1 >= 0)
                l2 = arr2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0)
                    return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                else
                    return (double) Math.max(l1, l2);
            }

            else if (l1 > r2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}