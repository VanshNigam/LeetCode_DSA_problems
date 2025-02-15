class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        HashMap<Character, Integer> minLens = new HashMap<>();
        int secondMin = Integer.MAX_VALUE, count = 0;

        for (int i = 0; i < points.length; ++i) {
            int len = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            char c = s.charAt(i);

            if (!minLens.containsKey(c)) {
                minLens.put(c, len);
            } else if (len < minLens.get(c)) {
                secondMin = Math.min(minLens.get(c), secondMin);
                minLens.put(c, len);
            } else {
                secondMin = Math.min(len, secondMin);
            }
        }   

        for(int len : minLens.values()) {
            if(len < secondMin) {
                count++;
            } 
        }

        return count;
    }
}