class Solution {
    void merge(int arr[], int st, int mid, int end) {
        int left = st;
        int right = mid + 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                ans.add(arr[left]);
                left++;
            } else {
                ans.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            ans.add(arr[left]);
            left++;
        }
        while (right <= end) {
            ans.add(arr[right]);
            right++;
        }
        for (int i = st; i <= end; i++) {
            arr[i] = ans.get(i - st);
        }
    }

    int devide(int arr[], int st, int end) {
        int cnt = 0;
        if (st >= end)
            return cnt;
        int mid = (st + end) / 2;

        cnt += devide(arr, st, mid);
        cnt += devide(arr, mid + 1, end);

        cnt += countPairs(arr, st, mid, end);

        merge(arr, st, mid, end);
        return cnt;
    }

    public static int countPairs(int arr[], int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right])
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return devide(nums, 0, nums.length - 1);
    }
}