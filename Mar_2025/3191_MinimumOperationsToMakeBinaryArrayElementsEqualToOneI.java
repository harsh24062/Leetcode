class Solution {
    public int minOperations(int[] nums) {
        int ans=0;

        for(int i=0;i<nums.length-2;i++){
           if(nums[i]==0){
            ans++;
            nums[i]=1;
            nums[i+1]^=1;  //xor with 1 flips 1 to 0 and 0 to 1 
            nums[i+2]^=1;
           }
        }

        for(int i=nums.length-2;i<nums.length;i++){
            if(nums[i]==0)return -1;
        }

        return ans;
    }
}
