class Solution {

    private int ans;
    private List<List<Integer>> adj;

    long dfs(int curNode, int parentNode,int[] values, int k){
        long sum = 0;
        for(int i:adj.get(curNode)){
           if(i!=parentNode)sum+= dfs(i,curNode,values,k);
        }
        sum+=values[curNode];
        if(sum%k==0){
            ans++;
            sum=0;
        }
        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        
        ans=0;
        // make adjancecy list
        adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int edge[]:edges){
          adj.get(edge[0]).add(edge[1]);
          adj.get(edge[1]).add(edge[0]);
        }

       dfs(0,-1,values,k);

       return ans;
    }
}
