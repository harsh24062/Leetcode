class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // divide problem
        // iterate on nums then 
        // find pairs whose sum is less than lower   -- x
        // find pairs whose sum is less than eqaul to upper  -- y
        // add  y-x in ans
        
        // we can sort as we need pairs ..koi change nahi hoga
        Arrays.sort(nums);

        long ans=0;

        for(int i=0;i<nums.length;i++){
          int low = lower - nums[i] -1;  //taking -1 here because i want to take   less than lower
          int high = upper - nums[i];

          int x = findElements(nums,i+1,low,i); // low ka max. index find karo using binary search and maxIndex - i return karo  
          int y = findElements(nums,i+1,high,i);

          ans+=(y-x); 
        }

        return ans;
    }

    int findElements(int nums[], int low, int num, int i){
        if(low == nums.length)return 0;

        int high = nums.length-1;

        while(low<=high){
            int mid =low+ (high-low)/2;
            if(nums[mid]<=num)low=mid+1;
            else high=mid-1;
        }

        return high-i  ;
    }
}
