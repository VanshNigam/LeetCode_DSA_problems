class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[j] = c;
                        String next = new String(chars);

                        if (next.equals(endWord)) return level + 1;

                        if (dict.contains(next)) {
                            queue.offer(next);
                            dict.remove(next); // avoid revisiting
                        }
                    }
                    chars[j] = original; // restore original char
                }
            }
            level++;
        }
        return 0; // no path found
    }
}
