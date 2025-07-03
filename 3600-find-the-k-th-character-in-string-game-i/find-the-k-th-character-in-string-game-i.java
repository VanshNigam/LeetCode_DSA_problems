class Solution {
    public char kthCharacter(int k) {
        // Approach :-
        // ab.bc|bccd|| bccdcdde
        // 1->2->4->8->16
        //   k=16th character ->d
        //   s.charAt 15=>d =binary is 1111(15)
        // ans is 'a'+4 =>d
        int c=0;
        k--; //for getting index
        while(k>0){
            if((k&1)==1)c++;
            k=k>>1;
        }

        return (char)(c+'a');
    }
}