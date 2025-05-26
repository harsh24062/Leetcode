class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int inDegree[] = new int[n];

        for(int edge[]:edges){
          adj.get(edge[0]).add(edge[1]);
          inDegree[edge[1]]++;
        }
        
        Queue<Integer> queue= new LinkedList<>();
        int colorCount[][] = new int[n][26];    


        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.add(i);
                colorCount[i][colors.charAt(i)-'a']=1;
            }
        }     
        
        int ans=0;
        int countNode=0;

        while(!queue.isEmpty()){
           int node=queue.poll();
           countNode++;
           ans=Math.max(ans,colorCount[node][colors.charAt(node)-'a']);

           for(int i:adj.get(node)){
            for(int c=0;c<26;c++){
                colorCount[i][c] = Math.max(colorCount[i][c],(colorCount[node][c] + ((colors.charAt(i)-'a'==c)?1:0)));
            }
            inDegree[i]--;
            if(inDegree[i]==0){
                queue.offer(i);
            }
           }
        }
         if(countNode<n)return -1;
       return ans;
    }
}
