class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));

        int result=0;
        int endDay=0; // initially 0

        for(int meet[]:meetings){
           if(meet[0]>endDay){
            result+=meet[0]-endDay-1;
           }

           endDay=Math.max(endDay,meet[1]);
        }

        if(days>endDay){
            result+=days-endDay;
        }

        return result;
    }
}
