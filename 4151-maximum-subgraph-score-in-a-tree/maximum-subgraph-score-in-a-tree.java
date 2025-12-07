class Solution {
    public void rec2(int i,int par,List<List<Integer>> adj,int ans[],int score[]){
        ans[i]=score[i];
        for(int j:adj.get(i)){
            if(j==par) continue;
            score[j]=Math.max(score[j],score[j]+(score[j]>0?ans[i]-score[j]:ans[i]));
            rec2(j,i,adj,ans,score);
        }
    }
    public void rec(int i,int par,List<List<Integer>> adj,int score[]){
        if(score[i]==0) score[i]=-1;
        for(int j:adj.get(i)){
            if(j==par) continue;
            rec(j,i,adj,score);
            score[i]=Math.max(score[i],score[i]+score[j]);
        }
    }
    public int[] maxSubgraphScore(int n, int[][] edges, int[] score) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i[]:edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        rec(1,-1,adj,score);
        int ans[]=new int[n];
        rec2(1,-1,adj,ans,score);
        return ans;
    }
}