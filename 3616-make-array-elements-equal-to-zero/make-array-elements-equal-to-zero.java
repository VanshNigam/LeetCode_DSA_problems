// class Solution {
//     public int countValidSelections(int[] nums) {
//         //optimal 
//         int n = nums.length;
//         int preSum[] = new int[n];

//         preSum[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             preSum[i] += preSum[i - 1] + nums[i];
//         }

//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == 0) {
//                 int leftSum = 0;
//                 int RightSum = preSum[n - 1] - preSum[i];
//                 if (i > 0)
//                     leftSum = preSum[i - 1];

//                 if (leftSum == RightSum)
//                     count += 2;
//                 else if (Math.abs(RightSum - leftSum) == 1)
//                     count++;
//             }
//         }
//         return count;
//     }
// }

//2nd approach
class Solution {
    public int countValidSelections(int[] nums) {
        //optimal 
        int n = nums.length, sum = 0;

        for (int i = 0; i < n; i++)
            sum += nums[i];

        int count = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += nums[i];
            if (nums[i] == 0) {
                int leftSum = curr;
                int RightSum = sum - curr;

                if (leftSum == RightSum)
                    count += 2;
                else if (Math.abs(RightSum - leftSum) == 1)
                    count++;
            }
        }
        return count;
    }
}