class Solution {
    public int minCost(String colors, int[] neededTime) {
     
       int count_time=0;
       int index=0;
       while(index<colors.length()){
          char ch = colors.charAt(index);
          int j=index;
          int max=0;
          long sum=0;
           while(j<colors.length() && colors.charAt(j)==ch){
            sum+=neededTime[j];
            max=Math.max(max,neededTime[j]);
            j++;
           }
           if(j-index>1){
            count_time+=(int)sum-max;
           }
           index=j;
       }

       return count_time;

    }
}
