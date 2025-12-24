class Solution {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int lastMax = 0;
        int ans = 0;
        for(int event[]:events){
           while(!pq.isEmpty() && pq.peek()[1]<event[0]){
             lastMax = Math.max(lastMax,pq.poll()[2]);
           }
           ans=Math.max(ans,lastMax+event[2]);
           pq.offer(event);
        }
        return ans;
    }
}  
