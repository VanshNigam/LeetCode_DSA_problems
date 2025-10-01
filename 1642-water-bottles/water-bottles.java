class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int temp = numBottles;
        while (temp >= numExchange) {
            int r = temp % numExchange;
            int p = temp / numExchange;
            temp = r + p;
            ans += p;
        }
        return ans;

    }
}