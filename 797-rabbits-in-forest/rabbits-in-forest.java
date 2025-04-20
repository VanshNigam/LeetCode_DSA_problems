class Solution {
    public int numRabbits(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        int c = 0;

        for (int i : arr) {
            int group = i + 1;
            if(i==0){
                c++;
                continue;
            }
            if (mp.containsKey(group)) {
                int fr = mp.get(group);
                if (fr > 1)
                    mp.put(group, fr - 1);
                else
                    mp.remove(group);
            } else {
                mp.put(group, i);
                c += group;
            }
            // System.out.println(mp+" "+c);
        }
        return c;
    }
}