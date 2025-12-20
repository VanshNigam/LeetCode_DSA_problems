class Solution {
    public int maximumSum(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();

        for (int i : nums) {
            if (i % 3 == 0)
                arr1.add(i);
            if (i % 3 == 1)
                arr2.add(i);
            if (i % 3 == 2)
                arr3.add(i);
        }
        Collections.sort(arr1, Collections.reverseOrder());
        Collections.sort(arr2, Collections.reverseOrder());
        Collections.sort(arr3, Collections.reverseOrder());
        int ans = 0;
        if (arr1.size() >= 3) {
            int temp = arr1.get(0) + arr1.get(1) + arr1.get(2);
            ans = Math.max(ans, temp);
        }
        if (arr2.size() >= 3) {
            int temp = arr2.get(0) + arr2.get(1) + arr2.get(2);
            ans = Math.max(ans, temp);
        }
        if (arr3.size() >= 3) {
            int temp = arr3.get(0) + arr3.get(1) + arr3.get(2);
            ans = Math.max(ans, temp);
        }
        if (arr3.size() >= 1 && arr2.size() >= 1 && arr1.size() >= 1) {
            int temp = arr3.get(0) + arr2.get(0) + arr1.get(0);
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}