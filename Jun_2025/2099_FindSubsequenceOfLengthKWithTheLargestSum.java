class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
        }

        PriorityQueue<int[]> pq1= new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        int ans[]=new int[k];

        for(int i=0;i<k;i++){
            pq1.offer(pq.poll());
        }

        for(int i=0;i<k;i++){
            ans[i]=pq1.poll()[0];
        }

        return ans;
    }
}
