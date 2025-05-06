class Solution {
    public int[] buildArray(int[] nums) {
        int a[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            a[i]=nums[nums[i]];
        }
        return a;
    }
}


// recursion
class Solution {
    public int[] buildArray(int[] nums) {
        solve(0,nums);
        return nums;
    }

    void solve(int index, int[] nums){
        if(index>=nums.length)return;

        int result = nums[nums[index]];
        solve(index+1,nums);
        nums[index]=result;
    }
}
