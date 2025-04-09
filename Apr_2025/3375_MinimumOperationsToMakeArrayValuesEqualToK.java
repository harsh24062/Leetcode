class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();

        for(int i:nums){
            if(i<k) return -1;
            set.add(i);
        }
        int ans=set.size()-1;
        if(!set.contains(k))ans++;
      return ans;
    }
}
