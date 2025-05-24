class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            int c = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == x) {
                    c++;
                }
            }
            if (c > 0) {
                    lst.add(i);
                }
        }
        return lst;
    }
}