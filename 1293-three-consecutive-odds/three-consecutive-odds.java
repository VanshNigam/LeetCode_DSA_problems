class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int c=0;
        for(int i:arr){
            if(i%2==0)c=0;
            else c+=1;
            if(c==3)return true;
        }
        return false;
    }
}