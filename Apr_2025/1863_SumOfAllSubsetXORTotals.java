class Solution {
    public int subsetXORSum(int[] nums) {
         return xor(nums,0,0);
    }
    public int xor(int[]nums,int index,int sum){
        if(index==nums.length) return sum;
        int pick=xor(nums,index+1,sum^nums[index]);
        int notpick=xor(nums,index+1,sum);
        return pick+notpick;
    }
}
