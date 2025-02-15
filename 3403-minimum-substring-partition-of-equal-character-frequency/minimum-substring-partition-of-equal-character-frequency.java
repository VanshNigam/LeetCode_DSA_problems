class Solution {
    public boolean isBalanced(int[] charFreq) {
        int minFreq = 1001, maxFreq = 0;
        for (int Freq : charFreq) {
            if (Freq > 0) {
                minFreq = Math.min(minFreq , Freq);
                maxFreq = Math.max(maxFreq , Freq);
            }
        }
        return minFreq == maxFreq;
    }

    public int minimumSubstringsInPartition(String S) {
        int N = S.length();
        int[] DP = new int[N];
        Arrays.fill(DP,N);
        for (int END = 0 ; END < N ; END++){
            int[] charFreq = new int[26];
            for (int START = END ; START >= 0 ; START--){
                charFreq[S.charAt(START) - 'a']++;
                if (isBalanced(charFreq)){
                    DP[END] = START > 0 ? Math.min(DP[END] , 1 + DP[START - 1]) : 1;
                }
            }
        }
        return DP[N - 1];
    }
}