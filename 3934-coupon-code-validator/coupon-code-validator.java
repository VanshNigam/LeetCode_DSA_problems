class Solution {
    public List<String> validateCoupons(String[] code, String[] b, boolean[] a) {
        List<String[]> prev = new ArrayList<>();

        Map<String, Integer> pq = new HashMap<>();
        pq.put("electronics", 0);
        pq.put("grocery", 1);
        pq.put("pharmacy", 2);
        pq.put("restaurant", 3);

        int n = code.length;

        for (int i = 0; i < n; i++) {
            if (a[i]) {
                if (!code[i].isEmpty() && code[i] != null && code[i].matches("[a-zA-Z0-9_]+")) {
                    String temp = b[i];
                    if (temp != null && pq.containsKey(temp)) {
                        prev.add(new String[] { code[i], temp });
                    }
                }
            }
        }
        prev.sort((x, y) -> {
            int cmp = Integer.compare(pq.get(x[1]), pq.get(y[1]));
            if (cmp != 0)
                return cmp;
            return x[0].compareTo(y[0]);
        });

        // Extract sorted codes
        List<String> ans = new ArrayList<>();
        for (String[] pair : prev) {
            ans.add(pair[0]);
        }

        return ans;
    }
}
