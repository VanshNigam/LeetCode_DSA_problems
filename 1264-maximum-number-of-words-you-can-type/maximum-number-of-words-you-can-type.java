class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> st = new HashSet<>();

        // Add broken letters to a set for quick lookup
        for (int x = 0; x < brokenLetters.length(); x++) {
            st.add(brokenLetters.charAt(x));
        }
        boolean flag = true;
        int c = 0;
        for (int y = 0; y < text.length(); y++) {
            char ch = text.charAt(y);
            if (ch == ' ') {
                if (flag) {
                    c++;
                }
                flag = true;
            } else if (st.contains(ch)) {
                flag = false;
            }
        }

        if (flag) {
            c++;
        }

        return c;
    }
}
