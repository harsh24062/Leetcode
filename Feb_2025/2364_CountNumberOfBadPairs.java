class Solution {
    //https://www.youtube.com/watch?v=9B60i0PPQG4
    public long countBadPairs(int[] nums) {

        // j - i != nums[j] - nums[i]
        // make this condition reverse
        // j - i = nums[j] - nums[i]  //try to find good pairs
        // j -nums[j] = i - nums[i]

        // <j-nums[j] , frequnecy>

        long n=nums.length;
     
        long totalPair =n*(n-1)/2;
        long goodPair=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
         goodPair+=map.getOrDefault(i-nums[i],0);
          map.put(i-nums[i],map.getOrDefault(i-nums[i],0)+1);
        }
      
      return totalPair-goodPair;
    }
}
