class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void help(List<Integer> lst, int k, int kr, int n, int i, int sum) {
        if (i > n)
            return;
        if (kr == 0) {
            if (sum == n) {
                ans.add(new ArrayList<>(lst));
            }
            return;
        }

        for (int i1 = i; i1 <= 9; i1++) {
            if (sum > n)
                return;
            lst.add(i1);
            help(lst, k, kr - 1, n, i1 + 1, sum + i1);
            lst.remove(lst.size() - 1);

        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> lst = new ArrayList<>();

        help(lst, k, k, n, 1, 0);
        return ans;
    }
}