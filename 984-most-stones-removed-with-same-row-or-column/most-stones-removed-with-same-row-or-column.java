class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int maxRow=0,maxCol=0;

        for(int i[]:stones){
            maxCol=Math.max(maxCol,i[1]);
            maxRow=Math.max(maxRow,i[0]);
        }
        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
        Map<Integer,Integer>mp=new HashMap<>();

        for(int i[]:stones){
            int x=i[0];
            int y=i[1]+maxRow+1;

            ds.unionByRank(x,y);
            mp.put(x,1);
            mp.put(y,1);
        }
        int c=0;
        for(int i:mp.keySet()){
            if(ds.findUPar(i)==i)c++;
        }

        return stones.length-c;
    }
}