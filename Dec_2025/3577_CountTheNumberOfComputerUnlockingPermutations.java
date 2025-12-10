class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for(int i=1;i<n;i++){
            if(complexity[i]<=complexity[0])return 0;
        }

        long result = 1;

        for (int i = 2; i <= n-1; i++) {
        result = (result*i)%1000000007;
        }

       return (int)result;
    }
}
