class Solution {
    public boolean isCon(Character c) {
        char ch = Character.toLowerCase(c);
        return Character.isLetter(ch) && "aieou".indexOf(ch) == -1;
    }

    public boolean isValid(String word) {
        HashSet<Character> st = new HashSet<>();
        Collections.addAll(st, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        HashSet<Character> st2 = new HashSet<>();
        Collections.addAll(st2, '1', '2', '3', '4', '5', '6', '7', '8', '9', '0');
        if (word.length() < 3)
            return false;
        boolean vowel = false;
        boolean con = false;

        for (char x : word.toCharArray()) {
            if (st.contains(x))
                vowel = true;
            if (isCon(x))
                con = true;
            if (!(isCon(x) || st.contains(x) || st2.contains(x)))
                return false;
        }
        return vowel && con;
    }
}