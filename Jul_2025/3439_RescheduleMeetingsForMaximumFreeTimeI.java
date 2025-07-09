class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;

        int gap[]=new int[n+2];
        
        gap[0]=startTime[0]-0;
        
        gap[n]=eventTime-endTime[n-1];

        for(int i=1;i<n;i++){
            gap[i]=startTime[i]-endTime[i-1];
        }

      //  for(int i:gap)System.out.print(i);

        int max=0;
        int start=0;
        int end=k;

        for(int i=0;i<=end;i++) max+=gap[i];

        int sum=max;
 
        while(end<n+1){
         max=Math.max(max,sum);

            end++;
           
            sum+=gap[end];
            sum-=gap[start];
            start++;
        }

            return max;
    }
}
