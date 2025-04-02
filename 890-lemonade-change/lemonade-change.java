class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f=0; //5$
        int t=0; //10$

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5)f++;
            else if(bills[i]==10){
                if(f==0)return false;
                f--;
                t++;
            }else{
                if(f==0)return false;
                f--;
                if(f<2 && t==0)return false;
                if(t>0)t--;
                else f-=2;
            }
        }
        return true;
    }
}