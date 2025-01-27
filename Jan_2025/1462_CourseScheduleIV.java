// approach 1

// using dfs
//dfs approach
class Solution {

    boolean dfs(int src, int des, List<List<Integer>> adj, boolean visited[]){
      visited[src]=true;

      if(src==des) return true;

      for(int i:adj.get(src)){
        if(!visited[i]){
            if(dfs(i,des,adj,visited)) return true;
        }
      }

      return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

         List<Boolean> ans = new ArrayList<>();

        //make adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int k[] : prerequisites){
            adj.get(k[0]).add(k[1]);
           
        }   

        for(int k[] : queries){
            boolean visited[] =new boolean[numCourses];
            ans.add(dfs(k[0],k[1],adj,visited));
        }


        return ans;
    }
}



// approach -2 using topo sort

// approach  --- https://www.youtube.com/watch?v=ScJNPlYz1J4
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n=numCourses;
       
      // will do by topo sort

        List<Boolean> ans=new ArrayList<>();

        // Construct adjacency list
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        int inDegree[]=new int[n];

        for(int k[]:prerequisites){
          adj.get(k[0]).add(k[1]);
          inDegree[k[1]]++;
        }
       
       Queue<Integer> queue=new LinkedList<>();
       Map<Integer,Set<Integer>> map=new HashMap<>();

       for(int i=0;i<n;i++){
        if(inDegree[i]==0){
            queue.offer(i);
            map.put(i,new HashSet<>());
        }
       }

       while(!queue.isEmpty())
       {
         int node=queue.poll();

         for(int i:adj.get(node)){
             inDegree[i]--;
            
             if(!map.containsKey(i)){
              Set<Integer> newSet=new HashSet<>(map.get(node));
              newSet.add(node);
              map.put(i,newSet);
             }
             else{
                 Set<Integer> newSet=new HashSet<>(map.get(node));
                 newSet.add(node);
                 Set<Integer> newSet1=new HashSet<>(map.get(i));
                 for(Integer k:newSet) newSet1.add(k);
                map.put(i,newSet1);
             }

             if(inDegree[i]==0){
                queue.offer(i);
            }
          }
        }
   
        for(int k[]:queries){
            if(map.containsKey(k[1]) && map.get(k[1]).contains(k[0]) ) ans.add(true);

            else ans.add(false);
        }

        return ans;
    }
}
