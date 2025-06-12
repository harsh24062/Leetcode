class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff=Math.abs(nums[nums.length-1]-nums[0]);

        for(int i=0;i<nums.length-1;i++){
            diff=Math.max(diff,Math.abs(nums[i]-nums[i+1]));
        }
        return diff;
    }
}
