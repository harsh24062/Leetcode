class Solution {

    boolean dfs(List<List<Integer>> adj, int src, int des, boolean visited[]){
        visited[src]=true;

        if(src==des) return true;

        for(int i:adj.get(src)){
            if(!visited[i]){
                if(dfs(adj,i,des,visited)) return true;
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        
        int nodes=edges.length;
        
        // make adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<nodes+1;i++){ // doing nodes+1 because nodes are from 1 to n
          adj.add(new ArrayList<>());
        }
        
        // undirected graph
        for(int edge[]:edges){
          
          // if both nodes are already present in graph then adding one more edge will result in cycle..
          // if both node have a path between them ..thats why we will use dfs to check if there is path 
          // between nodes ... if there is path dfs will return true and that will be our answer
        if(adj.get(edge[1]).size()>0 && adj.get(edge[0]).size()>0 ){
         
          boolean visited[] = new boolean[nodes+1];

          if(dfs(adj,edge[0],edge[1],visited)){
            return new int[]{edge[0],edge[1]};
          }
        }

            adj.get(edge[1]).add(edge[0]);
            adj.get(edge[0]).add(edge[1]);
        }

     
  return new int[]{0,0};

    }
}
