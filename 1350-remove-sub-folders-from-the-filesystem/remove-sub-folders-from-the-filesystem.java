
//do not done by me

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        int i=0;
        int j = 1;
        int n = folder.length;
        ans.add(folder[0]);
        while(j<n){
            String a = folder[i];
            String b = folder[j];
            if(b.startsWith(a+"/")){
                j++;
            }
            else{
                ans.add(folder[j]);
                i=j;
                j++;
            }
        }
        return ans;
    }
}