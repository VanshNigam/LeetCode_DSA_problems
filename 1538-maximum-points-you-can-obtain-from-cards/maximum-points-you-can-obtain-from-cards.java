class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int ans = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        ans = leftSum;
        int rightIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[rightIndex];
            rightIndex--;
            ans = Math.max(ans, leftSum + rightSum);
        }
        return ans;
    }
}