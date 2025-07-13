class Solution {
    public int matchPlayersAndTrainers(int[] p, int[] t) {
        Arrays.sort(p);
        Arrays.sort(t);

        int x=0;
        for(int i=0;i<t.length;i++){
            if(t[i]>=p[x]){
                x++;
            }
            if(x==p.length)break;
        }
        return x;
    }
}