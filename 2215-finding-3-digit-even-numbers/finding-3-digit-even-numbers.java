class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : digits) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int num = 100; num <= 999; num++) {
            if (num % 2 != 0) continue; // must be even

            int t = num / 100, s = (num / 10) % 10, f = num % 10;

            Map<Integer, Integer> temp = new HashMap<>(mp);
            if (temp.containsKey(t) && temp.get(t) > 0) temp.put(t, temp.get(t) - 1);
            else continue;

            if (temp.containsKey(s) && temp.get(s) > 0) temp.put(s, temp.get(s) - 1);
            else continue;

            if (temp.containsKey(f) && temp.get(f) > 0) temp.put(f, temp.get(f) - 1);
            else continue;

            arr.add(num);
        }

        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
