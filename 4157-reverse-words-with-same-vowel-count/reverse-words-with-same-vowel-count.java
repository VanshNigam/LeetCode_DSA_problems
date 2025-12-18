class Solution {
    public String reverseWords(String s) {
        String[] st = s.split(" ");
        int[] count = new int[st.length];
        for(int i=0; i<st.length; i++) {
            for(char c:st[i].toCharArray()) {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    count[i]++;
                }
            }
        }
        for(int i=1; i<st.length; i++) {
            if(count[i] == count[0]) {
                st[i] = new StringBuilder(st[i]).reverse().toString();
            }
        }
        return String.join(" ", st);
    }
}