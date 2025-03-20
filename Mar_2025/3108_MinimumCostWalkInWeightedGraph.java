// shashcode approach ...i have revise dsu (union by rank)

class Solution {

    class DSU{
        int rank[];
        int parent[];

        DSU(int n){
          rank=new int[n];
          parent=new int[n];

          for(int i=0;i<n;i++){
              parent[i]=i;
            }
        }
        
        int findParent(int node){
           if(node==parent[node]) return node;
           parent[node]=findParent(parent[node]);
           return parent[node];
        }

        // union by rank
        void union(int node1, int node2){

           int node1root=findParent(node1);
           int node2root=findParent(node2);

           if(node1root==node2root)return;

           if(rank[node1root]<rank[node2root]){
             parent[node1root]=node2root;
           } else if(rank[node1root]>rank[node2root]){
             parent[node2root]=node1root;
           }else{
             parent[node2root]=node1root;
             rank[node1root]++;
           }
        }

    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        DSU dsu = new DSU(n);

        for(int edge[]:edges){
          dsu.union(edge[0],edge[1]);
        }

        int cost[]=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);

        for(int edge[]:edges){
            int parent=dsu.findParent(edge[0]);
            cost[parent]=cost[parent] & edge[2];
        }

        int ans[]=new int[query.length];
        int index=0;

       for(int q[]:query){
         int parent1=dsu.findParent(q[0]);
         int parent2=dsu.findParent(q[1]);

         if(parent1!=parent2)ans[index]=-1;
         else ans[index]=cost[parent2]; 

         index++;
       }

        return ans;

    }
}
