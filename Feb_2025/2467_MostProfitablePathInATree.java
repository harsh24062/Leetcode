//https://www.youtube.com/watch?v=uJiDHHChF58

class Solution {
    List<List<Integer>> adj;
    Map<Integer,Integer> bobMap;
    int aliceIncome=Integer.MIN_VALUE;
     
    boolean dfsBob(int bob,int time,boolean visit[]){
       visit[bob]=true;
       bobMap.put(bob,time);

       if(bob==0)return true;

       for(int i:adj.get(bob)){
        if(!visit[i]){
            if(dfsBob(i,time+1,visit))return true;
        }
       }

      bobMap.remove(bob);
       
       return false;
    }

   void dfsAlice(int node,int time,int income,int amount[],boolean visited[]){
        visited[node]=true;

        // if(bobMap.containsKey(node)){
        //    if(time<bobMap.get(node)) income+=amount[node];
        //    else if(time==bobMap.get(node)) income+=(amount[node]/2);
        // }

        if (!bobMap.containsKey(node) || time < bobMap.get(node)) {
            income += amount[node];
        } else if (time == bobMap.get(node)) {
            income += (amount[node] / 2);
        }

        //leaf node
        if(adj.get(node).size()==1 && node!=0){
            aliceIncome=Math.max(aliceIncome,income);
        }

        for(int i:adj.get(node)){
        if(!visited[i]){
            dfsAlice(i,time+1,income,amount,visited);
        }
       }
        
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        int n=amount.length;
        // create adjacency list
        adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int edge[]:edges){
         adj.get(edge[0]).add(edge[1]);
         adj.get(edge[1]).add(edge[0]);
        }

       // dfs on bob to determine time 
       int time=0;
       boolean visit[]=new boolean[n];
       bobMap=new HashMap<>();
       dfsBob(bob,time,visit);


       //Alice travel
       int income=0;
       boolean visited[]=new boolean[n];
       time=0;
       dfsAlice(0,time,income,amount,visited);

       return aliceIncome;
    }
}
