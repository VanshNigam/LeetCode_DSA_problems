class NumArray {
    int arr[];
    int nums[];
    int n;

    public void build_SegTree(int i, int l, int r) {
        //left==right
        if (l == r) {
            arr[i] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build_SegTree(2 * i + 1, l, mid);
        build_SegTree(2 * i + 2, mid + 1, r);
        arr[i] = arr[2 * i + 1] + arr[2 * i + 2];
    }

    public int segTree_sum(int i, int left, int right, int l, int r) {
        if (right < l || r < left)
            return 0;
        if (left <= l && r <= right)
            return arr[i];

        int mid = (l + r) / 2;
        int leftSum = segTree_sum(2 * i + 1, left, right, l, mid);
        int rightSum = segTree_sum(2 * i + 2, left, right, mid + 1, r);
        return leftSum + rightSum;
    }

    public void segTree_Upd(int i, int index, int UpdVal, int l, int r) {
        if (r == l) {
            nums[index] = UpdVal;
            arr[i] = UpdVal; // ✅ important fix
            return;
        }

        int mid = (l + r) / 2;
        if (index <= mid)
            segTree_Upd(2 * i + 1, index, UpdVal, l, mid);
        else
            segTree_Upd(2 * i + 2, index, UpdVal, mid + 1, r);
        arr[i] = arr[2 * i + 1] + arr[2 * i + 2];
    }

    public NumArray(int[] input) {
        n = input.length;
        arr = new int[4 * n];
        nums = input;
        build_SegTree(0, 0, n - 1);
    }

    public void update(int index, int val) {
        segTree_Upd(0, index, val, 0, n - 1);
    }

    public int sumRange(int left, int right) {
        return segTree_sum(0, left, right, 0, n - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */