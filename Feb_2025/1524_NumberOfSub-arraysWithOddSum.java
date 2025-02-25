class Solution {
    public int numOfSubarrays(int[] arr) {
        int ans=0;
        int prefixSum=0;
        int oddSum=0; // count oddSum
        int evenSum=1; // count evenSum     // prefixSum is initial 0
 
        for(int i:arr){
           prefixSum+=i;

           if(prefixSum%2==0){
             evenSum++;
             ans=(ans+oddSum)%1000000007;
           }else{
             oddSum++;
             ans=(ans+evenSum)%1000000007;
           }
        }

        return ans;
    }
}
