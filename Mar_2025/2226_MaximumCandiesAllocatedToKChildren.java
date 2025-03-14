class Solution {

   boolean isAllocated(int[] candies, int mid, long k){
       long countChild=0;
       for(int i:candies){
           countChild+=i/mid;
           if(countChild>=k)return true;
       }
       return false;
   }

    public int maximumCandies(int[] candies, long k) {

        //binary Search approach 

        long sum=0;
        int max=Integer.MIN_VALUE;

        for(int i:candies){
            sum+=i;
            max=Math.max(max,i);
        }

        if(k>sum)return 0;

        //childern will have atleast one candy so left=1
        //a children can have atmost max(candies) ...as child can be allocated candies from only one pile of candies  
        int left=1,right=max;

        while(left<=right){
          int mid= left + (right-left)/2;

          if(isAllocated(candies,mid,k))left=mid+1;
          else right=mid-1;
        }

        return right;
    }
}
