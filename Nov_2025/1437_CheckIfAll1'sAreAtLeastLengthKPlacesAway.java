class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        
        while(i<nums.length){
           if(nums[i]==0){i++; continue;}
           int j = 1;
           for(j=1;j<=k;j++){
             if(i+j<nums.length && nums[i+j]==1)return false;
           } 
           i=i+j;
        }
 
        return true;
    }
}
