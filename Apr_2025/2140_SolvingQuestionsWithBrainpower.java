// recursion

class Solution {
    
    long func(int index, int[][]questions){

        if(index>=questions.length)return 0;

       //solve
       long solve=questions[index][0]+func(index+questions[index][1]+1,questions);
       //dontSolve
       long dontSolve=func(index+1,questions);

       return Math.max(solve,dontSolve);
    }

    public long mostPoints(int[][] questions) {
        
       return func(0,questions);
    }
}



//memorzation


class Solution {
    // use DP- memorization
    
    long func(int index, int[][]questions, long dp[]){

        if(index>=questions.length)return 0;
        if(dp[index]!=0)return dp[index];  

       //solve
       long solve=questions[index][0]+func(index+questions[index][1]+1,questions,dp);
       //dontSolve
       long dontSolve=func(index+1,questions,dp);

       return dp[index]=Math.max(solve,dontSolve);
    }

    public long mostPoints(int[][] questions) {
        
       long dp[]=new long[questions.length]; 
       return func(0,questions,dp);
    }
}




