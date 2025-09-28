class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int area=0;
        
        for(int i=nums.length-1;i>=2;i--){
            for(int j=i-1;j>=1;j--){
                for(int k=j-1;k>=0;k--){
                    if(nums[j]+nums[k]>nums[i]){
                        return nums[j]+nums[i]+nums[k];
                    }
                }
            }
        }

        return area;
    }
}

// optimal
import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums); // sort ascending

        // Traverse from largest to smallest
        for (int i = nums.length - 1; i >= 2; i--) {
            // Check triangle inequality for the top 3
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                // valid triangle found
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        // No valid triangle
        return 0;
    }
}
