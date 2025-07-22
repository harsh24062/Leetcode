class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l=0,r=0;
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        
        int sum=0;
        while(r<nums.length){
            sum+=nums[r];
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(r-l+1!=map.size()){
             sum-=nums[l];
             map.put(nums[l],map.get(nums[l])-1);
             if(map.get(nums[l])==0)map.remove(nums[l]);
             l++;
            }
            ans=Math.max(ans,sum);
            r++;
        }

        return ans;
    }
}
