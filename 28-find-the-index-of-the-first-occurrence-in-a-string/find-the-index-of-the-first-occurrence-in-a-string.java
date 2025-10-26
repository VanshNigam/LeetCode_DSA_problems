// class Solution {
//     public int[] computeLPS(String pattern) {
//         int[] lps = new int[pattern.length()];
//         int len = 0;
//         int i = 1;
//         while (i < pattern.length()) {
//             if (pattern.charAt(i) == pattern.charAt(len)) {
//                 len++;
//                 lps[i] = len;
//                 i++;
//             } else {
//                 if (len != 0) {
//                     len = lps[len - 1];
//                 } else {
//                     lps[i] = 0;
//                     i++;
//                 }
//             }
//         }
//         return lps;
//     }
//     public int strStr(String text, String pattern) {
//         int[] lps = computeLPS(pattern);
//         // List<Integer> result = new ArrayList<>();
//         int i = 0, j = 0;
//         while (i < text.length()) {
//             if (text.charAt(i) == pattern.charAt(j)) {
//                 i++;
//                 j++;
//             }
//             if (j == pattern.length()) {
//                 // result.add(i - j);
//                 // j = lps[j - 1];
//                 return i-j;
//             }
//             else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
//                 if (j != 0) {
//                     j = lps[j - 1];
//                 } else {
//                     i++;
//                 }
//             }
//         }
//         return -1;
//     }
// }

// ---second version
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}