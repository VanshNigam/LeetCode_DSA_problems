class Solution {
    public int minimumOperations(int[] nums) {
       int arr[]=new int[101];
       int k=0;
        for(int i=nums.length-1;i>=0;i--){
            if(arr[nums[i]]>0)return (int) Math.ceil((double)(nums.length-k)/3);
            else arr[nums[i]]++;
            k++;
        }
        return 0;
    }
}