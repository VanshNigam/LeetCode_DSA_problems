class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();

        int arr[] = new int[26];
        int fr[] = new int[26];
        if (m > n) return ans; // no anagrams possible if p is longer than s

        for (int j = 0; j < m; j++) {
            fr[p.charAt(j) - 'a']++;
        }
        for (int j = 0; j < m; j++) {
            arr[s.charAt(j) - 'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (fr[i] != arr[i])
                flag = false;
        }
        if (flag)
            ans.add(0);
        for (int i = m; i < n; i++) {
            arr[s.charAt(i - m) - 'a']--;
            arr[s.charAt(i) - 'a']++;

            flag = true;
            for (int i1 = 0; i1 < 26; i1++) {
                if (fr[i1] != arr[i1])
                    flag = false;
            }
            if (flag)
                ans.add(i - m + 1);

        }
        return ans;
    }
}