class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int i:nums){
            sum=(sum+i)%p;
        }

        if(sum%p==0)return 0;

        int target = sum%p;

         HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Initialize with remainder 0 at index -1
        
        int curr = 0;
        int result = nums.length;
        
        // Traverse through the array
        for (int j = 0; j < nums.length; j++) {
            curr = (curr + nums[j]) % p;

            // Calculate the remainder needed to achieve the target
            int remain = (curr - target + p) % p;
            
            // If the required remainder exists in the map, update the result
            if (map.containsKey(remain)) {
                result = Math.min(result, j - map.get(remain));
            }
            
            // Store the current remainder with its index
            map.put(curr, j);
        }

        return result == nums.length ? -1 : result;
    }
}
