class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(List.of(1)));
        for (int i = 0; i < numRows - 1; i++) {
            // create a dummy arraylist
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.addAll(arr.get(arr.size() - 1));// purani vali array
            temp.add(0);

            List<Integer> nrow = new ArrayList<>();
            for (int j = 0; j < temp.size() - 1; j++) {
                // adding element
                nrow.add(temp.get(j) + temp.get(j + 1));
            }
            arr.add(nrow);
        }
        return arr;

    }
}