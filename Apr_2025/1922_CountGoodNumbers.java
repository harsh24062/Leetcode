class Solution {
    int mod=1000000007;

    long findPow(long a ,long b){
        if(b==0)return 1;
        long half=findPow(a,b/2);
        long result=(half*half)%mod;
        if(b%2!=0){
            result=(result*a)%mod;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenIndex=(n+1)/2;
        long oddIndex=(n/2);

        long even=findPow(5,evenIndex);
        long odd=findPow(4,oddIndex);
     
        long result= (even*odd)%mod;
        return (int)result;
    }
}
