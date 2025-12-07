class Solution {
    public int countOdds(int low, int high) {
        //odd till low - 1 
        //odd till high
        // then subtract odd_high - odd_low

        low = Math.max(low-1,0);
        int low_odd = (low%2==0)?low/2:(low/2)+1; 
        int high_odd = (high%2==0)?high/2:(high/2)+1; 
        return high_odd-low_odd;
    }
}
