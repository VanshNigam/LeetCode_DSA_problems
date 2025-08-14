class Solution {
    public String largestGoodInteger(String nums) {
        int max=-1;
        for (int i=0;i<nums.length()-2;i++){
            if(nums.charAt(i)==nums.charAt(i+1) && nums.charAt(i+1)==nums.charAt(i+2)){
                max=Math.max(Integer.parseInt(nums.charAt(i)+""),max);
                i+=2;            }
        }
        return max==-1?"":(""+max+""+max+""+max);
    }
}