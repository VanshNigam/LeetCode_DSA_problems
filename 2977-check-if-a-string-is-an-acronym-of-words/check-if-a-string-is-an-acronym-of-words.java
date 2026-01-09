class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String pre="";
        for(String x:words){
            pre+=x.charAt(0);
        }
        return pre.equals(s);
    }
}