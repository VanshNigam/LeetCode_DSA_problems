import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<List<Integer>> key = new ArrayList<>();

        // Group elements by (i+j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = i + j;
                if (key.size() <= sum) {
                    key.add(new ArrayList<>());
                }
                key.get(sum).add(mat[i][j]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < key.size(); i++) {
            if (i % 2 == 0) {
                Collections.reverse(key.get(i)); 
            }
            res.addAll(key.get(i));
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
