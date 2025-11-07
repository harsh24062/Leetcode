class Solution {

    private  List<List<Integer>> adj;
    private  int group[];
    private  HashMap<Integer,TreeSet<Integer>> map;

    void dfs(int curNode, int g){
        group[curNode]=g;
        map.get(g).add(curNode);

        for(int i:adj.get(curNode)){
          if(group[i]==0)  dfs(i,g);
        }
    }
    
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        
        // create adjacency list
        adj= new ArrayList<>();
        for(int i=0;i<=c;i++) adj.add(new ArrayList<>());

        for(int con[]:connections){
          adj.get(con[0]).add(con[1]);
          adj.get(con[1]).add(con[0]);
        }

        group = new int[c+1];
        int g=1;
        map = new HashMap<>();

        for(int i=1;i<=c;i++){
            if(group[i]==0){
                map.put(g,new TreeSet<>());
                dfs(i,g);
                g++;
            }
        }


        List<Integer> list = new ArrayList<>();

        for(int q[]:queries){
            int groupNum = group[q[1]];
            if(q[0]==2){
                map.get(groupNum).remove(q[1]);
            }else{
                if(map.get(groupNum).contains(q[1])){
                    list.add(q[1]);
                }else if(map.get(groupNum).isEmpty()){
                    list.add(-1);
                }else{
                    list.add(map.get(groupNum).first());
                    // map.get(groupNum).add(q[1]);
                }
            }
        }

        int ans[] = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }

        return ans;
    }
}
