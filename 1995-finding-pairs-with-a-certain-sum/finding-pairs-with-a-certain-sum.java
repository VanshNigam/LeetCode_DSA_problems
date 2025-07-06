class FindSumPairs {
    int a[];
    int b[];
    Map<Integer, Integer> mp;

    public FindSumPairs(int[] nums1, int[] nums2) {
        a = new int[nums1.length];
        b = new int[nums2.length];
        a = nums1;
        b = nums2;
        mp = new HashMap<>();
        for (int i : b) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val) {
        if (mp.get(b[index]) > 1) {
            mp.put(b[index], mp.get(b[index]) - 1);
        } else {
            mp.remove(b[index]);
        }
        b[index] += val;
        mp.put(b[index], mp.getOrDefault(b[index], 0) + 1);
    }

    public int count(int tot) {
        int c = 0;
        for (int i : a) {
            if (mp.containsKey(tot - i))
                c += mp.get(tot - i);
        }
        return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */