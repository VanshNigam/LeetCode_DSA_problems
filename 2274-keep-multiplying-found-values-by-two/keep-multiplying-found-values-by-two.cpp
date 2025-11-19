class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        set<int> st;
        for(int i: nums)st.insert(i);
        while(st.find(original)!=st.end()){
            original=original*2;
        }
        return original;
    }
};