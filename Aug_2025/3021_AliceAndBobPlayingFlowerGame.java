class Solution {
    public long flowerGame(int n, int m) {
        // total number og flower must be odd
        long odd1=n/2 +(n%2==0?0:1); 
        long even1=n/2; 
        long odd2=m/2+(m%2==0?0:1); 
        long even2=m/2; 

        long ans=odd1*even2;
        ans+=odd2*even1;
        return ans;
    }
}
