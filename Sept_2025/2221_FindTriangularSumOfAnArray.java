class Solution {
    public int triangularSum(int[] nums) {
        int steps= nums.length;
        while(steps>1){
            for(int i=0;i<steps-1;i++){
                nums[i]=(nums[i]+nums[i+1])%10;
            }
            steps--;
        }
        return nums[0];
    }
}
