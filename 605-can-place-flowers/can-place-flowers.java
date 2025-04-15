class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int c = 0;

        if (arr.length == 1 && arr[0] == 0 || arr[0] == 0 && arr[1] == 0) {
            c++;
            arr[0] = 1;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i - 1] == 0 && arr[i + 1] == 0) {
                arr[i] = 1;
                // n--;
                c++;
            }
            // if (n == 0)
            //     return true;
        }
        if (arr.length > 1 && arr[arr.length - 1] == 0 && arr[arr.length - 2] == 0) {
            c++;
            arr[arr.length - 1] = 1;
        }
        return n <= c;
    }
}