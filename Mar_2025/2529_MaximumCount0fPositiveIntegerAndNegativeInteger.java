//O(n)
class Solution {
    public int maximumCount(int[] nums) {
        int pos=0,neg=0;

        for(int i:nums){
            if(i>0)pos++;
            else if(i<0)neg++;
        }
        return Math.max(pos,neg);
    }
}

// by binary search

class Solution {

    int binaryNeg(int nums[]){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<0)left=mid+1;
            else right=mid-1;
        }
        return right+1;
    }

     int binaryPos(int nums[]){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<=0)left=mid+1;
            else right=mid-1;
        }
        return nums.length-left;
    }

    public int maximumCount(int[] nums) {

        int negNum=binaryNeg(nums);
        int posNum=binaryPos(nums);

        return Math.max(negNum,posNum);
    }
}
