class Solution {
    public List<Integer> partitionLabels(String s) {
        int l = s.length();
        int[] lastIndex = new int[26];
        for(int i = 0; i < l; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int rightBoundary = 0, start = 0;
        for(int i = 0; i < l; i++) {
            int last = lastIndex[s.charAt(i) - 'a'];
            rightBoundary = Math.max(rightBoundary, last);
            if(rightBoundary == i) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}