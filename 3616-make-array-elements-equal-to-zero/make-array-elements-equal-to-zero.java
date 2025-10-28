class Solution {
    public boolean check(int []arr,int i ,int in){
         while(i>=0 && i<arr.length){
            if(arr[i]==0)i+=in;
            else if(arr[i]>0){
                arr[i]--;
                in=-1*in;
                i+=in;
            }
         }
        for( i=0;i<arr.length;i++){
            if(arr[i]!=0)return false;
        }
        // System.out.println();
        return true;
    }
    public int countValidSelections(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            //left
            if(nums[i]==0 && check(nums.clone(),i,-1))c++;
            //right
            if(nums[i]==0 && check(nums.clone(),i,1))c++;
        }
        return c;
    }
}