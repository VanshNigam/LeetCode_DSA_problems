import java.util.Arrays;

class Solution {
    public int[] rev(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        return arr;
    }

    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int ind = -1;

        // Step 1: Find the pivot
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }

        // If no pivot found, reverse the array
        if (ind == -1) {
            rev(arr);
            return;
        }

        // Step 2: Find the rightmost element greater than arr[ind]
        for (int i = n - 1; i > ind; i--) {
            if (arr[i] > arr[ind]) {
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                break;
            }
        }

        // Step 3: Reverse the suffix
        Arrays.sort(arr, ind + 1, n);
    }
}
