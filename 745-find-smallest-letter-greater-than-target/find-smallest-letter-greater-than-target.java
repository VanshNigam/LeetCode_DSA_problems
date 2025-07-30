class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int st = 0;
        int end = letters.length - 1;

        while (st <= end) {
            int mid = (st + end) / 2;
            if ((letters[mid] - 'a') > (target - 'a')) {
                end = mid - 1;
            } else
                st = mid + 1;
        }
        return letters[st % letters.length];
    }
}