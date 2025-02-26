// kadane algo
class Solution {
    public int maxAbsoluteSum(int[] nums) {
      // calculate largest positive sum and largest negative sum and return max between them

      int posMax=Integer.MIN_VALUE;
      int posSum=0;
      int negMax=Integer.MAX_VALUE;
      int negSum=0;

      for(int i:nums){
        
        // hangle for postive case
        posSum+=i;
        posMax=Math.max(posMax,posSum);
        if(posSum<0)posSum=0;

        // hangle for negative case
        negSum+=i;
        negMax=Math.min(negMax,negSum);
        if(negSum>0)negSum=0;
      }
     negMax*=-1;
     return Math.max(posMax,negMax);
    }
}
