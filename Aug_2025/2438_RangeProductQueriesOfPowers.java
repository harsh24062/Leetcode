class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Long> power=new ArrayList<>();

        for(int i=0;i<32;i++){
            if((n & (1<<i))!=0){
                power.add((long)(1<<i));
            }
        }

        int ans[]=new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            long product=1;
            for(int j=start;j<=end;j++){
              product=(product*power.get(j))%1000000007;
            }
            ans[i]=(int)product;
        }
 
        return ans;
    }
}
