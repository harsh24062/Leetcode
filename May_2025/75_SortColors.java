class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int a=0,b=0,c=n-1;

        while(b<=c){
            if(nums[b]==1) b++;
            else if(nums[b]==0){
                nums[b]=nums[a];
                nums[a]=0;
                b++;
                a++;
            }
            else{
                nums[b]=nums[c];
                nums[c]=2;
                c--;
            }
        }
    }
}
