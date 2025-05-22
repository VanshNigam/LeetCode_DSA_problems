class Solution {

    int sum(int num) {
        int s = 0;
        while (num > 0) {
            s += num % 10;
            num /= 10;
        }
        return s;
    }

    int solve(int[] nums, int[][] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(nums[i], i);
        boolean[] v = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] || nums[i] == arr[i][1])
                continue;
            int size = 0;
            int j = i;
            while (!v[j]) {
                v[j] = true;
                j = map.get(arr[j][1]);
                size++;
            }
            if (size > 1)
                ans += (size - 1);
        }
        return ans;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sum(nums[i]);
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return solve(nums, arr);
    }
}
