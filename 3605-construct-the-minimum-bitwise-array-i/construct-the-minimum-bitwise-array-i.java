// class Solution {
//     public int[] minBitwiseArray(List<Integer> nums) {
//         int n=nums.size();
//         int ans[]=new int[n];
//         Arrays.fill(ans,-1);

//         for(int i=0;i<n;i++){
//             int x=nums.get(i);
//             for(int j=1;j<=x;j++){
//                 if((j|(j+1))==x){
//                     ans[i]=j;
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }

// -------------------2nd-------------------

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            if (x == 2)
                continue;
            for (int j = 1; j < 32; j++) {
                if ((x & (1 << j)) > 0) {
                    continue;
                } else {
                    int pre = j - 1;
                    ans[i] = x ^ (1 << (pre));
                    break;
                }
            }
        }
        return ans;
    }
}