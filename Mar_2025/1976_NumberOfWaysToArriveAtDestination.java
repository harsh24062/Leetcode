class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int road[]:roads){
            adj.get(road[0]).add(new int[]{road[1],road[2]});
            adj.get(road[1]).add(new int[]{road[0],road[2]});
        }

        long min[]=new long[n]; // min dis. from 0 to everynode
        Arrays.fill(min,Long.MAX_VALUE);
        min[0]=0;

        int ways[]=new int[n]; // no of ways to reach ith node in min dis.
        ways[0]=1;

        //long[] => [dis,node]
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long arr[]=pq.poll();
            long dis=arr[0];
            int node=(int)arr[1];

            for(int i[]:adj.get(node)){
                int nextNode=i[0];
                int nextDis=i[1];
                long nt=(dis+nextDis);
                if(nt<min[nextNode]){
                 min[nextNode]=nt;
                 ways[nextNode]=ways[node];
                 pq.offer(new long[]{nt,nextNode});
                }else if(nt==min[nextNode]){
                    ways[nextNode]=(ways[node]+ways[nextNode])%1000000007;
                }
            }
        }

        return ways[n-1];
    }
}
