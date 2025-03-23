class Solution {
    public long minOperations(int[][] queries) {
        //floor(num/4) is equiv to right shifting num twice.
        //Thus the number of floor(num/4) it takes for a given num to reach 0 depends on the position of its highest 1 bit
        //100 = 4, 10000 = 16, if 0 index the bits based on left shifts from one, floor divs it takes to move a num = floor(highestBit/2)
        //can use a prefix sumesque strat where calc number for up to r, then subtract up to l-1 from it
        //so need to calc number of floor(num/4) ops to make all number up to an int x = 0
        //1-3 needs 1, 4-15 needs 2, 16-63 needs 3, etc.
        //so for int x have 3*1 + 12*2 + 48*3 + ... all the way until the bit is reached. 
        //the prior sum is 3*1 + 3*4*2 + 3*4*4*3... = 3 + 3*4^1 * 2 + 3*4^2 * 3 + ....)
        //once we reach the range 4^i - x (as 4^(i+1) > x), then instead of 3 * 4^i * (i+1) term, have (x - 4^i + 1) * (i+1) term, as gap has x-4^i+1 nums instead of 4^(i+1)-4^i = 3*4^i terms


        long res = 0;
        for(int[] query : queries) {
            long floors = floorCnts(query[1]) - floorCnts(query[0]-1);
            res += (floors+1)/2;
        }
        return res;
    }

    private long floorCnts(int lim) {
        long res = 0;
        long pow4 = 4;
        int i = 1;
        while(lim >= pow4) {
            res += 3*i*(pow4/4);
            pow4 *= 4;
            i++;
        }
        res += (lim-(pow4/4)+1) * i;
        return res;
    }
}