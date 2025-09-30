class Solution {
    public int triangularSum(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i : nums)
            arr.add(i);

        while (arr.size() > 1) {
            ArrayList<Integer> temp = new ArrayList<>();
            int n = arr.size();
            for (int i = 0; i < n - 1; i++) {
                int x = (arr.get(i) + arr.get(i + 1)) % 10; // ✅ take mod 10
                temp.add(x);
            }
            arr = temp;
        }
        return arr.get(0);
    }
}