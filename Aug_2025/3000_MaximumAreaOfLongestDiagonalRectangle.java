class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxD=0;
        int maxA=0;
        
        for(int d[]:dimensions){
            int len = d[0];
            int wid = d[1];

            int c = len*len + wid*wid;

            if(c>=maxD){
                if(c>maxD || len*wid>maxA)
                maxA=len*wid;
                maxD=c;
            }
        }

        return maxA;
    }
}
