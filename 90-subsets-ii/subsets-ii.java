class Solution {

    public void help(int[] arr, List<Integer> temp, List<List<Integer>> result, int i) {
        if (i == arr.length) {
            result.add(new ArrayList<>(temp));
            System.out.println(result);
            return;
        }

        temp.add(arr[i]);
        help(arr, temp, result, i + 1);
         // Skip duplicates
        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            i++;
        }
        temp.remove(temp.size() - 1);
        help(arr, temp, result, i + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        help(nums, temp, result, 0);

        return result;
    }
}