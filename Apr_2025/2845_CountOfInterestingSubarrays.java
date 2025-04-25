//https://www.youtube.com/watch?v=MTQWe8qHcz0
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int mark[] = new int[n];
        int index=0;

        for(int i:nums){
          if(i%modulo==k)mark[index]=1;
          index++;
        }

        Map<Long,Long> map=new HashMap<>();
        map.put(0L,1L);

        long sum=0,ans=0;

        for(int i:mark){
            sum+=i;

            long r1=sum%modulo;

            long r2=(r1-k+modulo)%modulo;

            if(map.containsKey(r2))ans+=map.get(r2);

            map.put(r1,map.getOrDefault(r1,0L)+1);
        }

        return ans;
    }
}
