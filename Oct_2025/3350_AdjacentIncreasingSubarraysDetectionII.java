class Solution {
    int n;
    boolean isPossible(List<Integer> nums, int k){

        int currRun = 1;
        int prevRun = 0;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                currRun++;
            } else { // increasing order breaks here
                prevRun = currRun;
                currRun = 1;
            }

            // if current run itself can fit two subarrays of length k
            if (currRun >= 2 * k) {
                return true;
            }

            // if current and previous increasing runs can fit one subarray each
            if (Math.min(currRun, prevRun) >= k) {
                return true;
            }
        }

        return false;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        n = nums.size(); 
        if(n==2)return 1;

        int left=1,right=n/2;
      
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isPossible(nums,mid))left=mid+1;
            else right=mid-1;
        }
        return right;
    }
}
