class Solution {

   boolean isPossible(int[] nums, int k, int mid){
      int i=0;
      int count=0;

      while(i<nums.length){
        if(nums[i]<=mid){
            count++;
            i++;
        }
        if(count>=k)return true;
        i++;
      }
      return false;
   }

    public int minCapability(int[] nums, int k) {
        
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i:nums){
            max=Math.max(i,max);
            min=Math.min(i,min);
        }

      //binary Search  
        int left=min,right=max;

        while(left<=right){
           int mid=left+(right-left)/2;

           if(isPossible(nums,k,mid))right=mid-1;
           else left=mid+1;
        }
        return left;
    }
}
