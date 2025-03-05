class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        int arr[] = new int[n + 1];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        arr[1] = 0;
        List<List<Integer>>ans=new ArrayList<>();
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (arr[i] == 1)
                for (int j = i * i; j <= n; j+=i) {
                    arr[j] = 0;
                }
        }
        for(int i=1;i<=n/2;++i){
            if(arr[i]==1 && arr[n-i]==1)ans.add(new ArrayList<>(Arrays.asList(i, n-i)));

        }
        return ans;
    }
}