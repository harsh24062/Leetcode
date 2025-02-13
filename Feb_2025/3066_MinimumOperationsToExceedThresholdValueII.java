class Solution {
    
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i:nums) pq.offer((long)i);
        int ans=0;

        while(pq.size()>1 && pq.peek()<k){
            long first=pq.poll();
            long second=pq.poll();
            long result= (first*2);
            result=(result+second);
            ans++;
            pq.offer(result);
        }
        return ans; 
    }
}
