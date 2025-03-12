class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Boolean>mp=new HashMap<>();

        int i=0;
        int j=0;
        int max=0;

        while(j<s.length()){
            if(mp.containsKey(s.charAt(j))){
                 mp.remove(s.charAt(i));
                 i++;
            }else{
                mp.put(s.charAt(j),true);
                j++;
                max=Math.max(max,mp.size());
            }
        }
        return max;

    }
}