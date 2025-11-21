class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] row = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) row[i] = new StringBuilder();

        int i = 0, dir = 1; // start going down ⬇️
        for (char ch : s.toCharArray()) {
            row[i].append(ch);
            if (i == 0) dir = 1;            
            else if (i == numRows - 1) dir = -1;
            i += dir;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : row) ans.append(sb);
        return ans.toString();
    }
}
