class Solution {
    public int countLargestGroup(int n) {
        int arr[]=new int[40];
        int c = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int curr = i;
            while (curr > 0) {
                sum += curr % 10;
                curr = curr / 10;
            }
            arr[sum]++;
        }

        int max = 0;
        for (int i1 : arr) {
            if (i1 == max) 
                c++;
            else if ((i1) > max) {
                max = (i1);
                c = 1;
            }
        }
        return c;
    }
}