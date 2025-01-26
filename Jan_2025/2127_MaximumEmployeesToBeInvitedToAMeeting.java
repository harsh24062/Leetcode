class Solution {
    // approach


    int BFS(int node, List<List<Integer>> adj, boolean visited[]){
        
        // [node,distance]
        Queue<int[]> queue = new LinkedList<>();
        int distance = 0;

        queue.offer(new int[]{node,0});

        while(!queue.isEmpty()){
            int arr[] = queue.poll();

            for(int i : adj.get(arr[0])){
              if(!visited[i]){
               visited[i] = true;

               queue.offer(new int[]{i,arr[1]+1});

               distance = Math.max(distance,arr[1]+1);
              }
            }
        }

        return distance;
    }


    public int maximumInvitations(int[] favorite) {

        int nodes = favorite.length;

        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<nodes;i++) adj.add(new ArrayList<>());

        //make reverse adj List
        for(int i=0;i<nodes;i++){
            adj.get(favorite[i]).add(i);
        }

        int longestCycle = 0;
        int happyCycle = 0;  // cycle of length=2

        boolean visited[] =new boolean[nodes];

        for(int i=0;i<nodes;i++){

            if(!visited[i]){  // while cycle found

                Map<Integer,Integer> map=new HashMap<>();

                int curNode   = i;
                int nodeCount = 0;

                while(!visited[curNode]){
                    visited[curNode]=true;
                    map.put(curNode,nodeCount);

                    int nextNode = favorite[curNode];
                    nodeCount++;

                   if(map.containsKey(nextNode)){
                    int cycleLen =  nodeCount - map.get(nextNode);
                    longestCycle =  Math.max(longestCycle,cycleLen);

                    if(cycleLen==2){  // happycycle

                      boolean visited_bfs[] = new boolean[nodes];
                      visited_bfs[nextNode]=true;
                      visited_bfs[curNode]=true;
                     happyCycle+= BFS(curNode,adj,visited_bfs) + BFS(nextNode,adj,visited_bfs) +2;
                    }
                    break;
                   }

                   curNode=nextNode;
                }
            }
        }

     return Math.max(longestCycle,happyCycle);
    }
}
