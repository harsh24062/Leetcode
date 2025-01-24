class Solution {
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
         
         // using kahn algo
        // first,sabhi edges ko reverse karo
        //by making new adj list

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<graph.length;i++) adj.add(new ArrayList<>());
        int indegree[]=new int[graph.length];
         Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
            indegree[i]=graph[i].length;
            if(indegree[i]==0)queue.offer(i);
        }
        

        List<Integer> result=new ArrayList<>();

        while(!queue.isEmpty()){
           int node=queue.poll();
           result.add(node);
            for(int i:adj.get(node)){
                   indegree[i]--;
                   if(indegree[i]==0)queue.offer(i);   
            }
        }
        Collections.sort(result);
       return result;
    }
}
