class NumArray {
    int arr[];
    int nums[];
    int n;

    public void build(int i, int l, int r) {
        //left==right
        if (l == r) {
            arr[i] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * i + 1, l, mid);
        build(2 * i + 2, mid + 1, r);
        arr[i] = arr[2 * i + 1] + arr[2 * i + 2];
    }

    public int sum(int i, int left, int right, int l, int r) {
        if (right < l || r < left)
            return 0;
        if (left <= l && r <= right)
            return arr[i];

        int mid = (l + r) / 2;
        int leftSum = sum(2 * i + 1, left, right, l, mid);
        int rightSum = sum(2 * i + 2, left, right, mid + 1, r);
        return leftSum + rightSum;
    }

    public NumArray(int[] input) {
        n = input.length;
        arr = new int[4 * n];
        nums = input;
        build(0, 0, n - 1);
    }

    public int sumRange(int left, int right) {
        return sum(0, left, right, 0, n - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */