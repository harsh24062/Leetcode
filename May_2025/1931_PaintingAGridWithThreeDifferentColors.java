//https://www.youtube.com/watch?v=Qz8F-nC8oxQ

class Solution {
    List<String> colState;
    char colors[]={'R','G','B'};

    void generateCol(String cur,char prevChar,int l,int m){
       if(m==l){
        colState.add(cur);
        return;}

        for(char ch:colors){
         if(ch==prevChar)continue;
         generateCol(cur+ch,ch,l+1,m);
        }
    }

    public int colorTheGrid(int m, int n) {
       // Step 1 , generate first column possibility

       colState = new ArrayList<>();
       generateCol("",'#',0,m);

       int result=0;
       
       int dp[][] =new int[n][colState.size()];    //memorize
        
       for(int i=0;i<colState.size();i++){
         result = (result+ solve(n-1,i,m,dp))%1000000007;
       }
       
       return result;
    }

    int solve(int remainCols,int prevIndex,int m,int dp[][]){
        if(remainCols==0)return 1;

        if(dp[remainCols][prevIndex]!=0) return dp[remainCols][prevIndex];

        int ways=0;
        String prevString = colState.get(prevIndex);

        for(int i=0;i<colState.size();i++){
            String curString = colState.get(i);
            boolean flag = true;

            for(int j=0;j<m;j++){
                if(curString.charAt(j)==prevString.charAt(j)){
                    flag=false;
                    break;
                }
            }

            if(flag){
                ways= (ways+solve(remainCols-1,i,m,dp))%1000000007;
            }
             
        }
        return dp[remainCols][prevIndex]= ways;
    }
}
