// class Solution {
//     public List<List<Integer>> minimumAbsDifference(int[] arr) {
//         int min=Integer.MAX_VALUE;
//         int n=arr.length;
//         List<List<Integer>>ans=new ArrayList<>();
//         Arrays.sort(arr);

//         for(int i=0;i<n-1;i++){
//             // min=Math.min(min,Math.abs(arr[i],arr[i+1]));
//             if(min>Math.abs(arr[i]-arr[i+1])){
//                 min=Math.abs(arr[i]-arr[i+1]);
//                 ans=new ArrayList<>();
//                 ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i+1])));
//             }else if(min==Math.abs(arr[i]-arr[i+1])){
//                 ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i+1])));
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        int len = arr.length;
        int min = 1000000;
        Arrays.sort(arr);
        for (int i = 0; i < len - 1; i++) {
            min = Math.min(arr[i + 1] - arr[i], min);
        }
        for (int i = 0; i < len - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                res.add(list);

            }
        }
        return res;
    }
}