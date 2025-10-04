class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;
        int maxArea = 0;

        while (left < right) {

            int area = Math.min(arr[left], arr[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}