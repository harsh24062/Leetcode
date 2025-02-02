class Solution {
    public boolean check(int[] nums) {

        int n=nums.length;

        int rotate=-1; // mark index where array is rotated

        for(int i=1;i<n;i++){
           if(nums[i]<nums[i-1]){
            rotate=i;
            break;
           }
        }

        if(rotate==-1)return true;

        for(int i=rotate+1;i<n;i++){
            if(nums[i]<nums[i-1])return false;

            for(int j=0;j<rotate;j++){
                if(nums[j]<nums[i])return false;
            }
        }

         for(int j=0;j<rotate;j++){
                if(nums[j]<nums[rotate])return false;
            }

        return true;
    }
}
