class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void help(int arr[], int target, int curr, int i, List<Integer> lst) {
        if (curr > target || i >= arr.length)
            return;
        if (curr == target) {
            ans.add(new ArrayList<>(lst));
            return;
        }
        lst.add(arr[i]);
        help(arr, target, curr + arr[i], i, lst);

        lst.remove(lst.size() - 1);
        help(arr, target, curr, i + 1, lst);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        help(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }
}