class Solution {

    boolean isBipartite(int node, List<List<Integer>> adj, int color[], int curColor){
        color[node]=curColor;

        for(int i:adj.get(node)){
            if(color[i]==curColor) return false;

            if(color[i]==-1){
                if(!isBipartite(i,adj,color,1-curColor))return false;
            }
        }

        return true;
    }


    int bfs(int src, List<List<Integer>> adj, int n){

        int level=0;

        boolean visited[] =new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();

        visited[src]=true;

        queue.offer(src);

        while(!queue.isEmpty()){

            int size=queue.size();

            while(size-->0){
                int node=queue.poll();

                for(int i:adj.get(node)){
                    if(!visited[i]){
                        queue.offer(i);
                        visited[i]=true;
                    }
                }

            }
           level++;
        }

        return level;

    }

    int getMaxGroup(int node, boolean visited[], int height[], List<List<Integer>> adj){
        visited[node]=true;
        int max=height[node];
         
        for(int i:adj.get(node)){
            if(!visited[i]){
                max=Math.max(max,getMaxGroup(i,visited,height,adj));
            }
        }

        return max; 
    }



    public int magnificentSets(int n, int[][] edges) {

        //make adjacency List
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
          adj.add(new ArrayList<>());
        }
     
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //check graph is bipartite or not if not return -1
        int color[] = new int[n+1];
        Arrays.fill(color,-1);
        
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!isBipartite(i,adj,color,1)) return -1;
            }
        }

        //find each node height by bfs

        int height[] = new int[n+1];    // find level from node[i]

        for(int i=1;i<=n;i++){
            height[i]=bfs(i,adj,n);
        } 

        int maxGroups=0;

        boolean visited[]=new boolean[n+1];

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                maxGroups+= getMaxGroup(i,visited,height,adj);
            }
        }

        return maxGroups;
    }
}
