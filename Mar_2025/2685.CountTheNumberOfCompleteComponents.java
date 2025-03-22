//dfs

class Solution {
    int v=0;
    int e=0;
    boolean visited[];

    void dfs(int node,List<List<Integer>> list){
        v++;
        e+=list.get(node).size();
        visited[node]=true;

        for(int i:list.get(node)){
           if(!visited[i]){
            dfs(i,list);
           }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        
        int result=0;

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int edge[]:edges){
          int first=edge[0];
          int second=edge[1];
          adj.get(first).add(second);
          adj.get(second).add(first);
        }


        visited=new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
             v=0;
             e=0;

             dfs(i,adj);
             if(v*(v-1)==e)result++;
            }
        }

    return result;
    }
}




