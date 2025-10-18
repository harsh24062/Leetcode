class Solution {
    public int maxDistinctElements(int[] nums, int k) {
       Arrays.sort(nums);
       int count =1;
       int prev = nums[0]-k;

       for(int i=1;i<nums.length;i++){
        int newNum = prev+1;
         if(newNum>=nums[i]-k && newNum<=nums[i]+k){
            prev=newNum;
            count++;
         }if(nums[i]-k>newNum){
            prev=nums[i]-k;
            count++;
         }
       }

       return count;
    }
}
