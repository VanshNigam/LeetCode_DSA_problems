class Solution {
    public void sortColors(int[] nums) {
        int one=0;
        int two=0;
        int z=0;
        for(int i=0;i<nums.length;i++){
          if(nums[i]==1)
             one++;
          else if(nums[i]==2)
             two++;
          else
             z++;
        }
        int i=0;
        while(z!=0){nums[i]=0;z--;i++;}
        while(one!=0){nums[i]=1;one--;i++;}
        while(two!=0){nums[i]=2;two--;i++;}
        
        
    }
}