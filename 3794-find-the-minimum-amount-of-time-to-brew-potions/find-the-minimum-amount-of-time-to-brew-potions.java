class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long time[] = new long[n+1];
        time[0] = 0;
        
        for(int i = 0 ; i < m ; i++){
            long[] temp = new long[n+1];
            
            // Forward update
            for(int j = 0 ; j < n ; j++){
                if(i != 0 && time[j+1] > temp[j]){
                    temp[j] = time[j+1];
                }
                temp[j+1] += (temp[j] + skill[j] * mana[i]);
            }
            
            // Backward correction
            for(int j = n-1 ; j >= 0 ; j--){
                temp[j] = temp[j+1] - skill[j] * mana[i];
            }
            
            time = temp;
        }
        return time[n];
    }
}