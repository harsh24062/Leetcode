class Solution {
    public int countValidSelections(int[] nums) {

       int count = 0; // count ans
       int n = nums.length;
       // prefix Sum
       int prefixSum[] = new int[n];
       int postfixSum[] = new int[n];
       prefixSum[0]=nums[0];
       postfixSum[n-1]=nums[n-1];
       
       for(int i=0;i<n;i++){
          if(i>0)prefixSum[i]=nums[i] + prefixSum[i-1];
          if(i<n-1)postfixSum[n-i-2]= nums[n-i-2] + postfixSum[n-i-1];
       }
       
       for(int i=0;i<n;i++){
        if(nums[i]==0 && (prefixSum[i]==postfixSum[i]))count+=2;
        else if(nums[i]==0 && (Math.abs(prefixSum[i]-postfixSum[i])==1))count++;
       }
       
       return count;
    }
}
