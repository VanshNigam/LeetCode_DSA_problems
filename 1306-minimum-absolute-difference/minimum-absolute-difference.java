class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0;i<n-1;i++){
            // min=Math.min(min,Math.abs(arr[i],arr[i+1]));
            if(min>Math.abs(arr[i]-arr[i+1])){
                min=Math.abs(arr[i]-arr[i+1]);
                ans=new ArrayList<>();
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i+1])));
            }else if(min==Math.abs(arr[i]-arr[i+1])){
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i+1])));
            }
        }

        return ans;
    }
}