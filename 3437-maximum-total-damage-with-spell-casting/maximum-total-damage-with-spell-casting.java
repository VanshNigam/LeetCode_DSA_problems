import java.util.*;

class Solution {
    long[] dp;
    List<long[]> arr;

    long solve(int i) {
        int n = arr.size();
        if (i >= n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        long notTake = solve(i + 1);
        long take = arr.get(i)[1];
        int j = i + 1;
        while (j < n && arr.get(j)[0] - arr.get(i)[0] <= 2)
            j++;
        take += solve(j);
        return dp[i] = Math.max(take, notTake);
    }

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int x : power)
            map.put(x, map.getOrDefault(x, 0L) + x);
        arr = new ArrayList<>();
        for (var e : map.entrySet())
            arr.add(new long[] { e.getKey(), e.getValue() });
        arr.sort(Comparator.comparingLong(a -> a[0]));
        dp = new long[arr.size()];
        Arrays.fill(dp, -1);
        return solve(0);
    }
}