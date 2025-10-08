class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions,
                                long long success) {
        sort(potions.begin(), potions.end());
        int n = spells.size();
        int m = potions.size();
        vector<int> res(n, 0);
        for (int i = 0; i < n; i++) {
            int s= 0 , e =m-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                long long x = ((long long)spells[i] * (long long)potions[mid]);
                if (x >= success) {
                    e=mid-1;
                    res[i]=m-mid;
                }
                else{
                    s=mid+1;
                }
            }
            
        }
        return res;
    }
};