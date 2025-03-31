// https://www.youtube.com/watch?v=L-KWU8W3OqE
class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;
        if(k==n)return 0;
        

        long pairs[]=new long[n-1];

        for(int i=0;i<n-1;i++){
         pairs[i]=weights[i]+weights[i+1];
        }

        Arrays.sort(pairs);
        long max=0,min=0;

        for(int i=0;i<=k-2;i++){
         min+=pairs[i];
         max+=pairs[n-1-i-1];
        }


        return max-min;
        
    }
}
